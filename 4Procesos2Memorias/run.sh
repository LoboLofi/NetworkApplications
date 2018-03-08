clear
gcc semaforos.c memoria.c productor.c -o productor.out -lpthread
gcc semaforos.c memoria.c consumidor.c -o consumidor.out -lpthread

./productor.out &
./consumidor.out &
./productor.out &
./consumidor.out &
