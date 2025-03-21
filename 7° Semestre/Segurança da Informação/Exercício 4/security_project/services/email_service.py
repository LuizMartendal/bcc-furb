import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


def send_mfa_token_to_email(email, current_session_mfa):
    print(f"INFO: enviando código MFA para o email {email}")
    sender_email = "opaseguranca73@gmail.com"
    password = "lmyz yrtt hzad idkp"
    receiver_email = email

    message = MIMEMultipart()
    message['From'] = sender_email
    message['To'] = receiver_email
    message['Subject'] = "Login MFA"

    body = f"Use o código MFA com o token retornado para realizar o login completo: {current_session_mfa}"
    message.attach(MIMEText(body, 'plain'))
    send_email(sender_email, password, receiver_email, message, email)


def send_email(sender_email, password, receiver_email, message, email):
    server = smtplib.SMTP('smtp.gmail.com', 587)
    try:
        server.starttls()
        server.login(sender_email, password)

        # Envia o e-mail
        server.sendmail(sender_email, receiver_email, message.as_string())
        print(f"INFO: código MFA enviado para o email {email} com sucesso")
    except Exception as e:
        print(f"ERROR: erro ao enviar código MFA para o email {email}")
        print(e)
    finally:
        server.quit()
