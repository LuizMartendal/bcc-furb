#include <iostream>
#include <cuda_runtime.h>
#include <cuda.h>
#include <vector>
#include <atomic>
#include <thread>

// Vari�vel global para controlar quando parar o estresse
std::atomic<bool> stopStress(false);

// Fun��o para obter informa��es da GPU
void getGPUInfo() {
    int deviceCount;
    cudaGetDeviceCount(&deviceCount);

    if (deviceCount == 0) {
        std::cerr << "Nenhuma GPU CUDA dispon�vel." << std::endl;
        return;
    }

    for (int device = 0; device < deviceCount; ++device) {
        cudaDeviceProp prop;
        cudaGetDeviceProperties(&prop, device);
        std::cout << "Informa��es da GPU " << device << ":\n";
        std::cout << "  Nome: " << prop.name << std::endl;
        std::cout << "  Mem�ria Global: " << prop.totalGlobalMem / (1024 * 1024) << " MB" << std::endl;
        std::cout << "  Arquitetura: " << prop.major << "." << prop.minor << std::endl;
        std::cout << "  N�cleos de Processamento: " << prop.multiProcessorCount << std::endl;
        std::cout << "  Frequ�ncia: " << prop.clockRate / 1000 << " MHz" << std::endl;
        std::cout << std::endl;
    }
}

// Fun��o para estressar a GPU com opera��es de c�pia de mem�ria
void stressMemory() {
    const int N = 1 << 28;  // Aumentando o n�mero de elementos para uma c�pia de mem�ria maior
    float* d_a, * d_b;
    float* h_a = new float[N];
    float* h_b = new float[N];

    // Aloca��o de mem�ria na GPU
    cudaMalloc((void**)&d_a, N * sizeof(float));
    cudaMalloc((void**)&d_b, N * sizeof(float));

    // Inicializa os dados na mem�ria da CPU
    for (int i = 0; i < N; ++i) {
        h_a[i] = 1.0f;
    }

    while (!stopStress) {
        // Copia os dados para a mem�ria da GPU
        cudaMemcpy(d_a, h_a, N * sizeof(float), cudaMemcpyHostToDevice);
        cudaMemcpy(d_b, d_a, N * sizeof(float), cudaMemcpyDeviceToDevice);  // C�pia entre a GPU
        cudaMemcpy(h_b, d_b, N * sizeof(float), cudaMemcpyDeviceToHost);  // C�pia de volta para a CPU
    }

    // Libera a mem�ria alocada na GPU
    cudaFree(d_a);
    cudaFree(d_b);

    delete[] h_a;
    delete[] h_b;
}

// Fun��o para estressar a GPU com opera��es de mem�ria (aloca��o e desaloca��o repetidas)
void stressCopy() {
    const int N = 1 << 28;  // Aumentando o n�mero de elementos para testar mem�ria de forma mais intensiva
    float* d_data;

    while (!stopStress) {
        // Aloca e desaloca mem�ria v�rias vezes
        cudaMalloc((void**)&d_data, N * sizeof(float));
        cudaFree(d_data);
    }
}

// Fun��o para estressar a GPU com opera��es de 3D (realiza c�lculos simples em paralelo)
__global__ void kernel3D(float* d_out) {
    int idx = threadIdx.x + blockIdx.x * blockDim.x;
    if (idx < 1 << 28) {  // Aumentando o n�mero de threads processados
        d_out[idx] = sinf((float)idx) * cosf((float)idx);  // Simples c�lculo trigonom�trico
    }
}

void stress3D() {
    const int N = 1 << 28;  // N�mero de elementos
    float* d_out;

    cudaMalloc((void**)&d_out, N * sizeof(float));

    while (!stopStress) {
        // Aumentando a quantidade de blocos e threads
        kernel3D << <(N + 255) / 256, 256 >> > (d_out);
        cudaDeviceSynchronize();
    }

    cudaFree(d_out);
}

// Fun��o para estressar a GPU com opera��es de decodifica��o de v�deo
void stressVideoDecode() {
    const int N = 1 << 28;  // Tamanho dos dados para simular a decodifica��o
    uint8_t* d_data;

    // Aloca mem�ria na GPU
    cudaMalloc((void**)&d_data, N * sizeof(uint8_t));

    while (!stopStress) {
        // Simula o processamento de v�deo decodificado (operando com os dados)
        for (int i = 0; i < N; ++i) {
            d_data[i] = (uint8_t)(i % 255);
        }
    }

    cudaFree(d_data);
}

// Fun��o para estressar a GPU com opera��es de codifica��o de v�deo
void stressVideoEncode() {
    const int N = 1 << 28;  // Tamanho dos dados para simular a codifica��o
    uint8_t* d_data;

    // Aloca mem�ria na GPU
    cudaMalloc((void**)&d_data, N * sizeof(uint8_t));

    while (!stopStress) {
        // Simula o processamento de v�deo codificado (operando com os dados)
        for (int i = 0; i < N; ++i) {
            d_data[i] = (uint8_t)(i % 255);
        }
    }

    cudaFree(d_data);
}

// Fun��o para estressar a GPU com todas as opera��es
void stressGPU(int level, int device) {
    cudaSetDevice(device); // Seleciona a GPU correta

    // Exemplo de adapta��o do estresse com base na placa
    cudaDeviceProp prop;
    cudaGetDeviceProperties(&prop, device);
    std::cout << "Usando a GPU: " << prop.name << std::endl;

    switch (level) {
    case 1:
        std::cout << "Estressando a GPU com opera��es 3D..." << std::endl;
        stress3D();
        break;
    case 2:
        std::cout << "Estressando a GPU com c�pia de mem�ria..." << std::endl;
        stressCopy();
        break;
    case 3:
        std::cout << "Estressando a GPU com decodifica��o de v�deo..." << std::endl;
        stressVideoDecode();
        break;
    case 4:
        std::cout << "Estressando a GPU com codifica��o de v�deo..." << std::endl;
        stressVideoEncode();
        break;
    case 5:
        std::cout << "Estressando a GPU com opera��es de mem�ria..." << std::endl;
        stressMemory();
        break;
    case 6:
        std::cout << "Estressando a GPU com todas as opera��es..." << std::endl;
        stress3D();
        stressCopy();
        stressVideoDecode();
        stressVideoEncode();
        stressMemory();
        break;
    default:
        std::cout << "N�mero inv�lido. Escolha um n�mero entre 1 e 6." << std::endl;
    }
}

// Fun��o para permitir ao usu�rio parar o estresse com uma tecla
void stopStressInput() {
    char stop;
    std::cout << "Digite 'q' para parar o estresse: ";
    std::cin >> stop;
    if (stop == 'q') {
        stopStress = true;
    }
}

int main(int argc, char* argv[]) {
    // Exibir as informa��es da GPU
    getGPUInfo();

    int level = std::atoi(argv[1]);

    if (level < 1 || level > 6) {
        /*std::cout << "Selecione o tipo de teste a ser feito:\n";
        std::cout << "1 - Estressando a GPU com opera��es 3D\n";
        std::cout << "2 - Estressando a GPU com c�pia de mem�ria\n";
        std::cout << "3 - Estressando a GPU com decodifica��o de v�deo\n";
        std::cout << "4 - Estressando a GPU com codifica��o de v�deo\n";
        std::cout << "5 - Estressando a GPU com opera��es de mem�ria\n";
        std::cout << "6 - Estressando a GPU com todas as opera��es\n";
        std::cout << "Escolha: ";

        std::cin >> level;*/
        std::cout << "Entre com valores de teste v�lidos!";
        return 1;
    }

    // Estressar a GPU em um n�vel espec�fico (por exemplo, n�vel 6)
    std::thread stressThread(stressGPU, level, 0); // Modificar o n�mero da GPU conforme necess�rio

    // Aguardar a entrada do usu�rio para parar
    std::thread stopThread(stopStressInput);
    stopThread.join();

    // Finalizar o estresse
    stopStress = true;
    stressThread.join();

    return 0;
}
