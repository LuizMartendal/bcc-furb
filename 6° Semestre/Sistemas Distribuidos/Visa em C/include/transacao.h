#ifndef TRANSACAO_H
#define TRANSACAO_H

#define COMANDO_PAY "PAY"
#define QTD_DIGITOS_VISA 16
#define DIGITO_VISA '4'
#define COMMIT "COMMIT"
#define TAXA_DESCONTO 0.05

#define COMANDO_INVALIDO     3000
#define NR_CARTAO_INVALIDO   3001
#define CARTAO_NAO_VISA      3002
#define NOME_INVALIDO        3003
#define DATA_EXP_INVALIDA    3004
#define VALOR_INVALIDO       3005
#define SISTEMA_INDISPONIVEL 3006

struct transacao {
    char id[37];
    char nr_cartao[7];
    char *nome;
    char data_exp[8];
    double valor_cobrado;
    double valor_recebido;
};

bool validar_comando(const char* comando);

bool validar_cartao(const char *nr_cartao);

bool validar_tipo_visa(const char *nr_cartao);

bool validar_nome(const char *nome);

bool validar_data(const char *data);

double validar_valor(const char *valor_str, bool *valido);

bool validar_confirmacao(const char *confirmacao);

struct transacao *criar_transacao(const char *nr_cartao, const char *nome, const char *data_exp, double valor);

void liberar_transacao(struct transacao *transacao);

char *gerar_resposta(struct transacao *t);

#endif
