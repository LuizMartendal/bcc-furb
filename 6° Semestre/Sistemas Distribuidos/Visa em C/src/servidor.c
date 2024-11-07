#include <stdio.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <string.h>
#include <unistd.h>

#include "../include/servidor.h"

int obter_socket_servidor() {
    int descritor = socket(AF_INET, SOCK_STREAM, IPPROTO_IP);
    if (descritor < 0) {
        perror("Erro ao criar o descritor do socket do servidor");
        exit(EXIT_FAILURE);
    }
    return descritor;
}

struct sockaddr_in configurar_endereco() {
    struct sockaddr_in endereco = {
            .sin_family = AF_INET,
            .sin_port = htons(PORTA),
            .sin_addr.s_addr = INADDR_ANY
    };
    return endereco;
}


void configurar_servidor(int socket_servidor) {
    struct sockaddr_in endereco = configurar_endereco();
    definir_reutilizacao_porta(socket_servidor);
    vincular_servidor_endereco(socket_servidor, &endereco);
    escutar_socket(socket_servidor);
}

void escutar_socket(int socket_servidor) {
    if (listen(socket_servidor, 3) < 0) {
        perror("Erro ao iniciar escuta do socket");
        exit(EXIT_FAILURE);
    }
}


int aceitar_cliente(int socket_servidor) {
    struct sockaddr_in endereco_cliente;
    socklen_t tamanho_endereco_cliente = sizeof endereco_cliente;
    int socket_cliente =
            accept(socket_servidor, (struct sockaddr*) &endereco_cliente, &tamanho_endereco_cliente);
    if (socket_cliente < 0) {
        perror("Erro ao aceitar cliente");
        close(socket_servidor);
        exit(EXIT_FAILURE);
    }
    return socket_cliente;
}

void definir_reutilizacao_porta(int socket_servidor) {
    int opcao = ATIVAR_REUTILIZACAO;
    if (setsockopt(socket_servidor, SOL_SOCKET, SO_REUSEADDR, &opcao, sizeof(opcao)) < 0) {
        close(socket_servidor);
        perror("Erro ao configurar opção para reutilizar endereço");
        exit(EXIT_FAILURE);
    }
}

void vincular_servidor_endereco(int socket_servidor, struct sockaddr_in *endereco) {
    if (bind(socket_servidor, (struct sockaddr*) endereco, sizeof (*endereco)) == -1) {
        close(socket_servidor);
        perror("Erro vinculando o socket ao endereço");
        exit(EXIT_FAILURE);
    }
}

char *receber_mensagem(int socket_cliente, int socket_servidor) {
    char mensagem[256] = {0};
    memset(mensagem, 0, sizeof(mensagem));

    ssize_t recebido = recv(socket_cliente, mensagem, sizeof(mensagem) - 1, 0);
    if (recebido < 0)
        encerrar_com_erro(socket_cliente, socket_servidor, "Erro recebendo mensagem");
    else if (recebido == 0)
        encerrar_com_erro(socket_cliente, socket_servidor, "Conexão encerrada pelo cliente");

    mensagem[recebido] = '\0';
    return strdup(mensagem);
}

void enviar_mensagem(int socket_servidor, int socket_cliente, char *mensagem) {
    ssize_t total_enviado = 0;
    size_t comprimento_mensagem = strlen(mensagem);
    while (total_enviado < comprimento_mensagem) {
        ssize_t enviado = send(socket_cliente, mensagem + total_enviado,
                               comprimento_mensagem - total_enviado, 0);
        if (enviado < 0) {
            encerrar_com_erro(socket_cliente, socket_servidor, "Erro enviando mensagem");
        }
        total_enviado += enviado;
    }
}

void retornar_erro(int socket_servidor, int socket_cliente, int codigo) {
    if (codigo < 3000 || codigo > 3006) {
        encerrar_com_erro(socket_cliente, socket_servidor, "Código de erro inválido");
    }
    char mensagem_erro[12];
    snprintf(mensagem_erro, sizeof(mensagem_erro), "ERROR %d", codigo);
    if (send(socket_cliente, mensagem_erro, strlen(mensagem_erro), 0) < 0) {
        encerrar_com_erro(socket_cliente, socket_servidor, "Erro enviando mensagem de erro");
    }
    encerrar_com_erro(socket_cliente, socket_servidor, "Erro retornado ao cliente");
}

void encerrar_com_erro(int socket_cliente, int socket_servidor, char* mensagem) {
    encerrar_sockets(socket_servidor, socket_cliente);
    perror(mensagem);
    exit(EXIT_FAILURE);
}

void encerrar_sockets(int socket_servidor, int socket_cliente) {
    encerrar_socket(socket_servidor);
    encerrar_socket(socket_cliente);
}

void encerrar_socket(int socket) {
    if (socket != -1) close(socket);
}
