#ifndef SEMAFOROS_H
#define SEMAFOROS_H

void Esperar( int idSemaforo, int semN );

void Avanzar( int idSemaforo, int senN );

key_t ObtenerLlave();

int ObtnerIdSemaforo( key_t clave );

int LiberarSemaforo( int idSemaforo );

#endif
