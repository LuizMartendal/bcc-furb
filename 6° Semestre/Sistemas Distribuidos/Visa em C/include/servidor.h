
#ifndef SERVIDOR_H
#define SERVIDOR_H

#define PORTA 8900
#define ENDERECO_IP "127.0.0.1"
#define ATIVAR_REUTILIZACAO 1

int obter_socket_servidor();

struct sockaddr_in configurar_endereco();

void configurar_servidor(int socket_servidor);

void escutar_socket(int socket_servidor);

void vincular_servidor_endereco(int socket_servidor, struct sockaddr_in *endereco);

void definir_reutilizacao_porta(int socket_servidor);

int aceitar_cliente(int socket_servidor);

char *receber_mensagem(int socket_cliente, int socket_servidor);

void enviar_mensagem(int socket_servidor, int socket_cliente, char *mensagem);

void retornar_erro(int socket_servidor, int socket_cliente, int codigo);

void encerrar_com_erro(int socket_cliente, int socket_servidor, char* mensagem);

void encerrar_sockets(int socket_servidor, int socket_cliente);

void encerrar_socket(int socket);

#endif
