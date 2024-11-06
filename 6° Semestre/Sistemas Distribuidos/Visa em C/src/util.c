#include <sys/time.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdlib.h>
#include <time.h>

#include "../include/util.h"

void gerar_uuid(char uuid[37]) {
    char *numeros_hex = "0123456789abcdef";
    struct timeval tv;
    gettimeofday(&tv, NULL);
    unsigned int seed = (unsigned int)(tv.tv_sec ^ tv.tv_usec);

    for (int i = 0; i < 36; i++) {
        if (i == 8 || i == 13 || i == 18 || i == 23)
            uuid[i] = '-';
        else if (i == 14)
            uuid[i] = '4';
        else if (i == 19)
            uuid[i] = numeros_hex[(rand_r(&seed) % 4) + 8];
        else
            uuid[i] = numeros_hex[rand_r(&seed) % 16];
    }
    uuid[36] = '\0';
}

bool data_expirou(int mes, int ano) {
    time_t agora = time(NULL);
    struct tm *tempo_atual = localtime(&agora);
    int ano_atual = tempo_atual->tm_year + 1900;
    int mes_atual = tempo_atual->tm_mon + 1;
    if (ano < ano_atual)
        return true;
    else if (ano == ano_atual)
        return mes <= mes_atual;
    else
        return false;
}

void liberar_string(char *string) {
    free(string);
    string = NULL;
}

void liberar_recursos(char* recursos[], int total) {
    for (int i = 0; i < total; ++i) {
        liberar_string(recursos[i]);
    }
}
