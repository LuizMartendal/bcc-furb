import socket

def conectar_servidor():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect(('localhost', 8900))

        def enviar_mensagem(mensagem):
            s.send(mensagem.encode())
            resposta = s.recv(1024).decode()
            return resposta

        def enviar_e_verificar(mensagem):
            retorno = enviar_mensagem(mensagem)
            print(retorno)
            if retorno != "OK":
                return False
            return True

        mensagens = [
            "PAY",
            "4234567890123456",
            "ronaldo silva",
            "12/2025",
            "252.42",
            "COMMIT"
        ]

        for mensagem in mensagens:
            if not enviar_e_verificar(mensagem):
                return

conectar_servidor()