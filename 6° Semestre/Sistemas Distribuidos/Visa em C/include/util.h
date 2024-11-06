#ifndef UTIL_H
#define UTIL_H

void gerar_uuid(char uuid[37]);

bool data_expirou(int mes, int ano);

void liberar_string(char *string);

void liberar_recursos(char* recursos[], int total);

#endif
