import tensorflow as tf
import tensorflow_hub as hub
import psycopg2
import numpy as np

# Função para carregar o modelo USE e gerar embeddings
def gerar_embedding(frase):
    embed = hub.load("https://tfhub.dev/google/universal-sentence-encoder/4")
    embedding = embed([frase])[0].numpy()
    return embedding

# Função para converter embedding para string compatível com pgvector
def embedding_to_pgvector_str(embedding):
    return '[' + ','.join(map(str, embedding.tolist())) + ']'

# Função para buscar a frase mais similar no banco de dados
def buscar_frase_similar(frase_input):
    # Gerar embedding para a frase de entrada
    embedding_input = gerar_embedding(frase_input)
    embedding_input_str = embedding_to_pgvector_str(embedding_input)
    print(embedding_input_str)

    # Conectar ao banco de dados PostgreSQL
    conn = psycopg2.connect("dbname=pgvector port=5000 user=postgres password=postgres")
    cursor = conn.cursor()

    # Query para buscar a frase mais similar
    cursor.execute("""
        SELECT id, frase, embedding <=> %s::vector AS distancia
        FROM frases_embeddings
        ORDER BY distancia
        LIMIT 3;
    """, (embedding_input_str,))

    # Obter o resultado
    resultado = cursor.fetchall()
    conn.close()

    if resultado:
        return resultado
    else:
        return None

# Função principal
def main():
    # Obter a frase de entrada do usuário
    frase_input = input('Entre com uma frase ')

    # Buscar a frase mais similar no banco de dados
    resultado = buscar_frase_similar(frase_input)

    if resultado:
        for i in range(len(resultado)):
            id, frase, distancia = resultado[i]
            print(f"\nFrase mais similar encontrada (ID: {id}):")
            print(f"Frase: {frase}")
            print(f"Distância: {distancia}")
    else:
        print("Nenhuma frase similar encontrada.")

if __name__ == "__main__":
    main()