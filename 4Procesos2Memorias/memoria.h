#ifndef MEMORIA_H
#define MEMORIA_H

int ObtenerIdMemoriaCompartida( key_t clave, char **memoria );

int LiberarMemoriaCompartida( int idMemoria, char **memoria );

#endif
