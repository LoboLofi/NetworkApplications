#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/types.h>
#include <pthread.h>
#include <string.h>

#include "semaforos.h"
#include "memoria.h"

#define ___LEER_1___ 0
#define ___ESCRIBIR_1___ 1
#define ___LEER_2___ 2
#define ___ESCRIBIR_2___ 3

int idSemaforo,idMemoria, idMemoria2;
char *memoria2=NULL;
char *memoria=NULL;

void *escritura( void *arg ){
  for (size_t x = 0; x < 10; x++) {
    Esperar( idSemaforo, ___ESCRIBIR_1___ );
    *memoria = (char) ((int)'a') + x ;
    printf("Escribiendo mem 1: %s\n", memoria);
    Avanzar( idSemaforo, ___LEER_1___ );
    Esperar( idSemaforo, ___ESCRIBIR_2___ );
    *memoria = (char) ((int)'z') - x ;
    printf("Escribiendo mem 2: %s\n", memoria2);
    Avanzar( idSemaforo, ___LEER_2___ );

  }
}

int main(int argc, char const *argv[]){
  pthread_t hilo;
  key_t clave = ObtenerLlave();
  idSemaforo = ObtnerIdSemaforo(clave);
  idMemoria = ObtenerIdMemoriaCompartida(clave, &memoria);
  idMemoria2 = ObtenerIdMemoriaCompartida(clave, &memoria2);

  pthread_create(&hilo,NULL,escritura,NULL);
  pthread_join(hilo,NULL);

  return 0;
}
