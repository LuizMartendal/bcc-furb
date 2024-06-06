import tensorflow as tf
import tensorflow_hub as hub
import numpy as np
import psycopg2
 
# 1º Passo -> CARREGAR O MODELO 'USE' PRÉ-TREINADO PARA GERAR OS EMBEDINGS
embed = hub.load("https://tfhub.dev/google/universal-sentence-encoder/4")
 
# GERE O SCRIPT PARA PEGAR UMA FRASE DO TERMINAL E SALVAR NA VARIÁVEL
frase = 'What is your age?'
 
# 2º Passo -> GERAR OS EMBEDINGS
embedding = embed([frase])[0].numpy()
print(embedding)
 
# Converter o embedding para uma lista
embedding_list = embedding.tolist()
 
# Converter a lista para uma string formatada para pgvector
embedding_str = '[' + ','.join(map(str, embedding_list)) + ']'
 
# 3º Passo -> INSERIR A FRASE COM EMBEDDING NO BANCO DE DADOS
conn = psycopg2.connect("dbname=pgvector user=postgres password=postgres port=5000")
cursor = conn.cursor()
 
cursor.execute("INSERT INTO frases_embeddings (frase, embedding) VALUES (%s, %s)", (frase, embedding_str))
conn.commit()
conn.close()