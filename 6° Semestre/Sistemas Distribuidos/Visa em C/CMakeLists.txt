cmake_minimum_required(VERSION 3.25)
project(VisaPaymentSocket C)

set(CMAKE_C_STANDARD 11)

include_directories(include)

set(SOURCES
    src/main.c
    src/servidor.c
    src/transacao.c
    src/util.c
)

add_executable(VisaPaymentSocket ${SOURCES})
