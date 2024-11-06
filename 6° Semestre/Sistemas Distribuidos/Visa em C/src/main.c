#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#include "../include/servidor.h"
#include "../include/transacao.h"
#include "../include/util.h"

#define RESPOSTA_OK "OK"

bool validar_e_responder(bool condicao, int socket_servidor, int socket_cliente, int codigo_erro) {
    if (!condicao) {
        retornar_erro(socket_servidor, socket_cliente, codigo_erro);
        return false;
    }
    return true;
}

char* receber_mensagem_cliente(int socket_cliente, int socket_servidor) {
    return receber_mensagem(socket_cliente, socket_servidor);
}

bool validar_com_erro(char *mensagem, bool (*validar)(const char*),
                      int socket_servidor, int socket_cliente, int codigo_erro) {
    if (!validar(mensagem)) {
        liberar_string(mensagem);
        retornar_erro(socket_servidor, socket_cliente, codigo_erro);
        return false;
    }
    return true;
}

void converter_para_maiusculas(char *str) {
    for (char *caracter = str; *caracter != '\0'; ++caracter) {
        *caracter = (char)toupper((unsigned char)*caracter);
    }
}

int processar_conexao(int socket_servidor, int socket_cliente) {
    char *comando = receber_mensagem_cliente(socket_cliente, socket_servidor);
    if (!validar_com_erro(comando, validar_comando, socket_servidor,
                          socket_cliente, COMANDO_INVALIDO)) return EXIT_FAILURE;
    printf("Comando %s %s\n", comando, RESPOSTA_OK);
    enviar_mensagem(socket_servidor, socket_cliente, RESPOSTA_OK);
    liberar_string(comando);

    char *nr_cartao = receber_mensagem_cliente(socket_cliente, socket_servidor);
    if (!validar_com_erro(nr_cartao, validar_cartao, socket_servidor,
                          socket_cliente, NR_CARTAO_INVALIDO)) return EXIT_FAILURE;
    if (!validar_e_responder(validar_tipo_visa(nr_cartao), socket_servidor,
                             socket_cliente, CARTAO_NAO_VISA)) return EXIT_FAILURE;
    printf("Cartão tipo Visa %s\n", RESPOSTA_OK);
    enviar_mensagem(socket_servidor, socket_cliente, RESPOSTA_OK);

    char *nome = receber_mensagem_cliente(socket_cliente, socket_servidor);
    converter_para_maiusculas(nome);
    if (!validar_com_erro(nome, validar_nome, socket_servidor,
                          socket_cliente, NOME_INVALIDO)) return EXIT_FAILURE;
    printf("Nome %s %s\n", nome, RESPOSTA_OK);
    enviar_mensagem(socket_servidor, socket_cliente, RESPOSTA_OK);

    char *data_exp = receber_mensagem_cliente(socket_cliente, socket_servidor);
    if (!validar_com_erro(data_exp, validar_data, socket_servidor,
                          socket_cliente, DATA_EXP_INVALIDA)) return EXIT_FAILURE;
    printf("Data de expiração %s %s\n", data_exp, RESPOSTA_OK);
    enviar_mensagem(socket_servidor, socket_cliente, RESPOSTA_OK);

    char *valor_str = receber_mensagem_cliente(socket_cliente, socket_servidor);
    bool valor_valido = true;
    double valor = validar_valor(valor_str, &valor_valido);
    liberar_string(valor_str);
    if (!validar_e_responder(valor_valido, socket_servidor,
                             socket_cliente, VALOR_INVALIDO)) return EXIT_FAILURE;
    printf("Valor R$%.2f %s\n", valor, RESPOSTA_OK);
    enviar_mensagem(socket_servidor, socket_cliente, RESPOSTA_OK);

    char *confirmacao = receber_mensagem_cliente(socket_cliente, socket_servidor);
    if (validar_confirmacao(confirmacao)) {
        printf("Confirmação %s %s\n", confirmacao, RESPOSTA_OK);
        struct transacao *transacao = criar_transacao(nr_cartao, nome, data_exp, valor);
        if (!transacao) {
            retornar_erro(socket_servidor, socket_cliente, SISTEMA_INDISPONIVEL);
            return EXIT_FAILURE;
        }
        char *resposta_dados = gerar_resposta(transacao);
        liberar_transacao(transacao);
        if (!resposta_dados) {
            retornar_erro(socket_servidor, socket_cliente, SISTEMA_INDISPONIVEL);
            return EXIT_FAILURE;
        }

        char *resposta_final = malloc(strlen(RESPOSTA_OK) + strlen(resposta_dados) + 2);
        if (!resposta_final) {
            liberar_string(resposta_dados);
            retornar_erro(socket_servidor, socket_cliente, SISTEMA_INDISPONIVEL);
            return EXIT_FAILURE;
        }
        sprintf(resposta_final, "%s\n%s", RESPOSTA_OK, resposta_dados);

        enviar_mensagem(socket_servidor, socket_cliente, resposta_final);
        char *respostas[] = {resposta_dados, resposta_final};
        liberar_recursos(respostas, 2);
    }

    char* recursos[] = {nr_cartao, nome, data_exp, confirmacao};
    liberar_recursos(recursos, 4);

    return EXIT_SUCCESS;
}

int main() {
    printf("Iniciando servidor\n");
    int socket_servidor = obter_socket_servidor();
    printf("Socket de servidor criado\n");

    configurar_servidor(socket_servidor);
    printf("Servidor vinculado ao endereço %s\n", ENDERECO_IP);

    while (true) {
        int socket_cliente = aceitar_cliente(socket_servidor);
        printf("Servidor conectado ao cliente\n");

        int status = processar_conexao(socket_servidor, socket_cliente);
        printf("Status: %d\n", status);
        encerrar_socket(socket_cliente);
    }

    encerrar_socket(socket_servidor);
    return EXIT_SUCCESS;
}
