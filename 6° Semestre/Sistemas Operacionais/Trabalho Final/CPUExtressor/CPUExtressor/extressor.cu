#include <iostream>
#include <cuda_runtime.h>
#include <cuda.h>
#include <vector>
#include <atomic>
#include <thread>

// Variável global para controlar quando parar o estresse
std::atomic<bool> stopStress(false);

// Função para obter informações da GPU
void getGPUInfo() {
    int deviceCount;
    cudaGetDeviceCount(&deviceCount);

    if (deviceCount == 0) {
        std::cerr << "Nenhuma GPU CUDA disponível." << std::endl;
        return;
    }

    for (int device = 0; device < deviceCount; ++device) {
        cudaDeviceProp prop;
        cudaGetDeviceProperties(&prop, device);
        std::cout << "Informações da GPU " << device << ":\n";
        std::cout << "  Nome: " << prop.name << std::endl;
        std::cout << "  Memória Global: " << prop.totalGlobalMem / (1024 * 1024) << " MB" << std::endl;
        std::cout << "  Arquitetura: " << prop.major << "." << prop.minor << std::endl;
        std::cout << "  Núcleos de Processamento: " << prop.multiProcessorCount << std::endl;
        std::cout << "  Frequência: " << prop.clockRate / 1000 << " MHz" << std::endl;
        std::cout << std::endl;
    }
}

// Função para estressar a GPU com operações de cópia de memória
void stressMemory() {
    const int N = 1 << 28;  // Aumentando o número de elementos para uma cópia de memória maior
    float* d_a, * d_b;
    float* h_a = new float[N];
    float* h_b = new float[N];

    // Alocação de memória na GPU
    cudaMalloc((void**)&d_a, N * sizeof(float));
    cudaMalloc((void**)&d_b, N * sizeof(float));

    // Inicializa os dados na memória da CPU
    for (int i = 0; i < N; ++i) {
        h_a[i] = 1.0f;
    }

    while (!stopStress) {
        // Copia os dados para a memória da GPU
        cudaMemcpy(d_a, h_a, N * sizeof(float), cudaMemcpyHostToDevice);
        cudaMemcpy(d_b, d_a, N * sizeof(float), cudaMemcpyDeviceToDevice);  // Cópia entre a GPU
        cudaMemcpy(h_b, d_b, N * sizeof(float), cudaMemcpyDeviceToHost);  // Cópia de volta para a CPU
    }

    // Libera a memória alocada na GPU
    cudaFree(d_a);
    cudaFree(d_b);

    delete[] h_a;
    delete[] h_b;
}

// Função para estressar a GPU com operações de memória (alocação e desalocação repetidas)
void stressCopy() {
    const int N = 1 << 28;  // Aumentando o número de elementos para testar memória de forma mais intensiva
    float* d_data;

    while (!stopStress) {
        // Aloca e desaloca memória várias vezes
        cudaMalloc((void**)&d_data, N * sizeof(float));
        cudaFree(d_data);
    }
}

// Função para estressar a GPU com operações de 3D (realiza cálculos simples em paralelo)
__global__ void kernel3D(float* d_out) {
    int idx = threadIdx.x + blockIdx.x * blockDim.x;
    if (idx < 1 << 28) {  // Aumentando o número de threads processados
        d_out[idx] = sinf((float)idx) * cosf((float)idx);  // Simples cálculo trigonométrico
    }
}

void stress3D() {
    const int N = 1 << 28;  // Número de elementos
    float* d_out;

    cudaMalloc((void**)&d_out, N * sizeof(float));

    while (!stopStress) {
        // Aumentando a quantidade de blocos e threads
        kernel3D << <(N + 255) / 256, 256 >> > (d_out);
        cudaDeviceSynchronize();
    }

    cudaFree(d_out);
}

// Função para estressar a GPU com operações de decodificação de vídeo
void stressVideoDecode() {
    const int N = 1 << 28;  // Tamanho dos dados para simular a decodificação
    uint8_t* d_data;

    // Aloca memória na GPU
    cudaMalloc((void**)&d_data, N * sizeof(uint8_t));

    while (!stopStress) {
        // Simula o processamento de vídeo decodificado (operando com os dados)
        for (int i = 0; i < N; ++i) {
            d_data[i] = (uint8_t)(i % 255);
        }
    }

    cudaFree(d_data);
}

// Função para estressar a GPU com operações de codificação de vídeo
void stressVideoEncode() {
    const int N = 1 << 28;  // Tamanho dos dados para simular a codificação
    uint8_t* d_data;

    // Aloca memória na GPU
    cudaMalloc((void**)&d_data, N * sizeof(uint8_t));

    while (!stopStress) {
        // Simula o processamento de vídeo codificado (operando com os dados)
        for (int i = 0; i < N; ++i) {
            d_data[i] = (uint8_t)(i % 255);
        }
    }

    cudaFree(d_data);
}

// Função para estressar a GPU com todas as operações
void stressGPU(int level, int device) {
    cudaSetDevice(device); // Seleciona a GPU correta

    // Exemplo de adaptação do estresse com base na placa
    cudaDeviceProp prop;
    cudaGetDeviceProperties(&prop, device);
    std::cout << "Usando a GPU: " << prop.name << std::endl;

    switch (level) {
    case 1:
        std::cout << "Estressando a GPU com operações 3D..." << std::endl;
        stress3D();
        break;
    case 2:
        std::cout << "Estressando a GPU com cópia de memória..." << std::endl;
        stressCopy();
        break;
    case 3:
        std::cout << "Estressando a GPU com decodificação de vídeo..." << std::endl;
        stressVideoDecode();
        break;
    case 4:
        std::cout << "Estressando a GPU com codificação de vídeo..." << std::endl;
        stressVideoEncode();
        break;
    case 5:
        std::cout << "Estressando a GPU com operações de memória..." << std::endl;
        stressMemory();
        break;
    case 6:
        std::cout << "Estressando a GPU com todas as operações..." << std::endl;
        stress3D();
        stressCopy();
        stressVideoDecode();
        stressVideoEncode();
        stressMemory();
        break;
    default:
        std::cout << "Número inválido. Escolha um número entre 1 e 6." << std::endl;
    }
}

// Função para permitir ao usuário parar o estresse com uma tecla
void stopStressInput() {
    char stop;
    std::cout << "Digite 'q' para parar o estresse: ";
    std::cin >> stop;
    if (stop == 'q') {
        stopStress = true;
    }
}

int main(int argc, char* argv[]) {
    // Exibir as informações da GPU
    getGPUInfo();

    int level = std::atoi(argv[1]);

    if (level < 1 || level > 6) {
        /*std::cout << "Selecione o tipo de teste a ser feito:\n";
        std::cout << "1 - Estressando a GPU com operações 3D\n";
        std::cout << "2 - Estressando a GPU com cópia de memória\n";
        std::cout << "3 - Estressando a GPU com decodificação de vídeo\n";
        std::cout << "4 - Estressando a GPU com codificação de vídeo\n";
        std::cout << "5 - Estressando a GPU com operações de memória\n";
        std::cout << "6 - Estressando a GPU com todas as operações\n";
        std::cout << "Escolha: ";

        std::cin >> level;*/
        std::cout << "Entre com valores de teste válidos!";
        return 1;
    }

    // Estressar a GPU em um nível específico (por exemplo, nível 6)
    std::thread stressThread(stressGPU, level, 0); // Modificar o número da GPU conforme necessário

    // Aguardar a entrada do usuário para parar
    std::thread stopThread(stopStressInput);
    stopThread.join();

    // Finalizar o estresse
    stopStress = true;
    stressThread.join();

    return 0;
}
