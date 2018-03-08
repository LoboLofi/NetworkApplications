#include <stdio.h>
#include <stdlib.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/types.h>
#include "semaforos.h"
void Esperar( int idSemaforo, int semN ){
    struct sembuf operacion;
    operacion.sem_num = semN;
    operacion.sem_op = -1;
    operacion.sem_flg = SEM_UNDO;
    semop( idSemaforo, &operacion, 1 );
}

void Avanzar( int idSemaforo, int senN ){
    struct sembuf operacion;
    operacion.sem_num = senN;
    operacion.sem_op = 1;
    operacion.sem_flg = SEM_UNDO;
    semop( idSemaforo, &operacion, 1 );
}

key_t ObtenerLlave(){
  return ftok( "/bin/ls", 15 );
}

int ObtnerIdSemaforo( key_t clave ){
    int idSemaforo;
    if( ( idSemaforo = semget(clave, 4, 0777|IPC_EXCL| IPC_CREAT) ) < 0 ){
        idSemaforo = semget(clave,4,0777);
    } else {
        semctl( idSemaforo, 0, SETVAL, 0 );
        semctl( idSemaforo, 1, SETVAL, 1 );
        semctl( idSemaforo, 2, SETVAL, 0 );
        semctl( idSemaforo, 3, SETVAL, 1 );
    }
    return idSemaforo;
}

int LiberarSemaforo( int idSemaforo ){
    return semctl( idSemaforo, 0, IPC_RMID, 0 );
}
