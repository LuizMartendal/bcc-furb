import tensorflow as tf
import tensorflow_hub as hub
import numpy as np
import psycopg2
 
# 1º Passo -> CARREGAR O MODELO 'USE' PRÉ-TREINADO PARA GERAR OS EMBEDINGS
embed = hub.load("https://tfhub.dev/google/universal-sentence-encoder/4")
 
# 2° Passo -> ENTRE COM A(S) FRASE(S) QUE SERÁ/SERÃO GERADA(S) - DEVEM SER DIVIDIDAS POR ' | '
frases = input('Entre com as frases ')
frases = frases.split(' | ')

conn = psycopg2.connect("dbname=pgvector user=postgres password=postgres port=5000")

for i in range(len(frases)):
    # 3º Passo -> GERAR OS EMBEDINGS
    embedding = embed([frases[i]])[0].numpy()
    print(embedding)
    
    # Converter o embedding para uma lista
    embedding_list = embedding.tolist()
    
    # Converter a lista para uma string formatada para pgvector
    embedding_str = '[' + ','.join(map(str, embedding_list)) + ']'
    
    # 4º Passo -> INSERIR A FRASE COM EMBEDDING NO BANCO DE DADOS
    cursor = conn.cursor()
    
    cursor.execute("INSERT INTO frases_embeddings (frase, embedding) VALUES (%s, %s)", (frases[i], embedding_str))
    conn.commit()

conn.close()