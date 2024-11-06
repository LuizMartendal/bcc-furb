# Use a imagem base com CMake e GCC
FROM gcc:latest

# Instala o CMake
RUN apt-get update && apt-get install -y cmake && apt-get clean

# Define o diretório de trabalho
WORKDIR /app

# Copia o código fonte e arquivos CMake para o contêiner
COPY . .

# Cria um diretório build e usa o CMake para configurar e compilar
RUN mkdir -p build && cd build && cmake .. && make

# Define o comando padrão para iniciar o contêiner
CMD ["./build/VisaPaymentSocket"]
