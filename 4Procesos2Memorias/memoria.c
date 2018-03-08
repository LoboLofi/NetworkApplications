#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/types.h>
#include "memoria.h"

#define TAM 100

int ObtenerIdMemoriaCompartida( key_t clave, char **memoria ){
  int idMemoria = shmget(clave,sizeof(char)*TAM, 0777 | IPC_CREAT |IPC_EXCL);
  if( idMemoria < 0  ){
    idMemoria = shmget(clave,sizeof(char)*TAM, 0777);
  }

  // printf("id memoria: %d\n",idMemoria);
  *memoria = (char *)shmat(idMemoria,(char *)0, 0);
  // printf("%p\n", (*memoria) );
  if( *memoria == NULL ){
    puts( "error" );
    exit(-1);
  }
  return idMemoria;
}

int LiberarMemoriaCompartida( int idMemoria, char **memoria ){
  shmdt( (char*) *memoria );
  return shmctl( idMemoria, IPC_RMID, (struct shmid_ds*) NULL);
}
