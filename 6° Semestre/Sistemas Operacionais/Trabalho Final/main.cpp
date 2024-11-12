#include "cuda_runtime.h"
#include "device_launch_parameter.h"

#include <stdio.h>
#include <iostream>

using namespace std;

__gloabal__ void somarVetores(int *vetorResposta, const int *vetorUm, const int *vetorDois) {
    int i = blockIdx.x * blockDim.x + threadIdx.x;
    vetorResposta[i] = vetorUm[i] + vetorDois[i];
}

int main() {
    const int tamanho = 5;
    const int vetorUm[tamanho] = {};
    const int vetorDois[tamanho] = {};
    int vetorResposta[tamanho] = {};

    int *D_vetUm, *D_vetDois, *D_vetResposta;

    cudaMalloc(&D_vetUm, tamanho * sizeof(int));
    cudaMalloc(&D_vetDois, tamanho * sizeof(int));
    cudaMalloc(&D_vetResposta, tamanho * sizeof(int));

    cudaMemcpy(D_vetUm, vetorUm, tamanho * sizeof(int), cudaMemcpyMostToDevice);
    cudaMemcpy(D_vetDois, vetorDois, tamanho * sizeof(int), cudaMemcpyMostToDevice);
    cudaMemcpy(D_vetResposta, vetorResposta, tamanho * sizeof(int), cudaMemcpyMostToDevice);

    somarVetores<<<1, tamanho>>>(D_vetResposta, D_vetUm, D_vetDois);

    cudaMemcpy(vetorResposta, D_vetResposta, tamanho * sizeof(int), cudaMemcpyDeviceToHost);

    cout << "Somando vetores... ";
    for (int i = 0; i < tamanho; i++) {
        cout << vetorResposta[i];
        if (i < 4) {
            cout << ", ";
        }
    }
}