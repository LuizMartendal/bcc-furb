#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <limits.h>
#include <stdio.h>
#include <errno.h>

#include "../include/util.h"
#include "../include/transacao.h"

bool validar_comando(const char* comando) {
    return (strcmp(comando, COMANDO_PAY) == 0);
}

bool validar_cartao(const char *nr_cartao) {
    errno = 0;
    char *endptr;
    long val = strtol(nr_cartao, &endptr, 10);
    return errno == 0 && *endptr == '\0' && val > LONG_MIN && val < LONG_MAX;
}

bool validar_tipo_visa(const char *nr_cartao) {
    return strlen(nr_cartao) == QTD_DIGITOS_VISA && nr_cartao[0] == DIGITO_VISA;
}

bool validar_nome(const char *nome) {
    size_t tamanho = strlen(nome);
    return tamanho > 3 && tamanho < 256;
}

bool validar_data(const char *data) {
    if (strlen(data) != 7 || data[2] != '/') return false;
    int mes = (data[0] - '0') * 10 + (data[1] - '0');
    int ano = (data[3] - '0') * 1000 + (data[4] - '0') * 100 + (data[5] - '0') * 10 + (data[6] - '0');
    return (mes >= 1 && mes <= 12 && ano >= 1900) && !data_expirou(mes, ano);
}

double validar_valor(const char *valor_str, bool *valido) {
    errno = 0;
    char *fim;
    double valor = strtod(valor_str, &fim);
    *valido = (*fim == '\0' && errno == 0);
    return valor;
}

bool validar_confirmacao(const char *confirmacao) {
    return (strcmp(confirmacao, COMMIT) == 0);
}

void mascarar_cartao(const char *nr_cartao, struct transacao *nova_transacao);

struct transacao *criar_transacao(const char *nr_cartao, const char *nome,
                                  const char *data_exp, double valor) {
    struct transacao *nova_transacao = malloc(sizeof(struct transacao));
    if (!nova_transacao) return NULL;

    gerar_uuid(nova_transacao->id);

    mascarar_cartao(nr_cartao, nova_transacao);

    nova_transacao->nome = strdup(nome);
    if (!nova_transacao->nome) {
        free(nova_transacao);
        nova_transacao = NULL;
        return NULL;
    }
    nova_transacao->valor_cobrado = valor;
    nova_transacao->valor_recebido = valor - (valor * TAXA_DESCONTO);

    strncpy(nova_transacao->data_exp, data_exp, sizeof(nova_transacao->data_exp) - 1);
    nova_transacao->data_exp[sizeof(nova_transacao->data_exp) - 1] = '\0';

    return nova_transacao;
}

void mascarar_cartao(const char *nr_cartao, struct transacao *nova_transacao) {
    int ultimos_digitos = 6;
    strncpy(nova_transacao->nr_cartao, nr_cartao + QTD_DIGITOS_VISA - ultimos_digitos, ultimos_digitos);
    nova_transacao->nr_cartao[6] = '\0';
}

void liberar_transacao(struct transacao *transacao) {
    if (transacao) {
        free(transacao->nome);
        transacao->nome = NULL;
        free(transacao);
        transacao = NULL;
    }
}

size_t obter_tamanho_transacao(const struct transacao *t) {
    size_t tamanho_nome = t->nome ? strlen(t->nome) : 0;
    return sizeof t->id + tamanho_nome + sizeof t->nr_cartao +
           sizeof t->data_exp + sizeof t->valor_cobrado + sizeof t->valor_recebido;
}

char *gerar_resposta(struct transacao *t) {
    if (!t || !t->nome) return NULL;

    size_t tamanho_dados = obter_tamanho_transacao(t);
    char *dados = malloc(tamanho_dados);
    if (!dados) return NULL;

    snprintf(dados, tamanho_dados, "%s:%s:%s:%s:%.2f:%.2f",
             t->id, t->nome, t->nr_cartao, t->data_exp, t->valor_cobrado, t->valor_recebido);
    return dados;
}
