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

int idSemaforo,idMemoria;
char *memoria=NULL;

void *escritura( void *arg ){
  int x = 0;
  while( x < 10 ){
    Esperar( idSemaforo, ___ESCRIBIR_1___ );
    *memoria = (char) ((int)'a') + x ;
    printf("Escribiendo : %s\n", memoria);
    // strcpy( memoria, a );
    x++;
    Avanzar( idSemaforo, ___LEER_1___ );
  }
}

int main(int argc, char const *argv[]){
  pthread_t hilo;
  key_t clave = ObtenerLlave();
  idSemaforo = ObtnerIdSemaforo(clave);
  idMemoria = ObtenerIdMemoriaCompartida(clave, &memoria);

  // printf("%p\n", memoria);
  // *memoria = (char) ((int)'a') + 1 ;
  // printf("Escribiendo : %s\n", memoria);

  pthread_create(&hilo,NULL,escritura,NULL);
  pthread_join(hilo,NULL);

  LiberarSemaforo( idSemaforo );
  LiberarMemoriaCompartida( idMemoria, &memoria );

  return 0;
}
