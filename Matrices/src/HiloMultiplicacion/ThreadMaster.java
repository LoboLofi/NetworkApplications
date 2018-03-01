package multiplicacionmatrices;

import HiloMultiplicacion.HiloMultiplicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ThreadMaster{
  Matrices matriz;
  int numHilos;
  int rango;
  int sigDisponible;
  int maxM;

  public ThreadMaster( int numHilos, int m, Matrices mat){
    this.numHilos = numHilos;
    if( numHilos % m == 0 ){
      this.rango = numHilos/m;
    }else{

      this.rango = (numHilos/m)+1;
    }
    this.maxM = m;
    this.sigDisponible = 0;
    this.matriz = mat;
  }

  public void EjecturarHilos( ){
    HiloMultiplicador hilos[this.numHilos];
    for( HiloMuiltiplicador hilo : hilos ){
      if( this.sigDisponibl >= m  )
        continue;
      HiloMultiplicacion(this.matriz, this.sigDisponible, this.sigDisponible, this.sigDisponible+rango );
      this.sigDisponible += rango;
    }
    for( HiloMuiltiplicador hilo : hilos ){
      hilo.join();
    }
  }
}
