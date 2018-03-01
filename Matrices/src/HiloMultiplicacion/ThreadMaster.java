package multiplicacionmatrices;

import HiloMultiplicacion.HiloMultiplicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ThreadMaster{
  Matrices matriz {get,set};
  int numHilos {get;set;}
  int rango;
  int sigDisponible;

  public ThreadMaster( int numHilos, int m, Matrices mat){
    this.numHilos = numHilos;
    this.rango =  numHilos % m ? numHilos/m:0;
    this.sigDisponible = 0;
    this.matriz = mat;
  }

  public EjecturarHilos( ){
    HiloMultiplicador hilos[this.numHilos];
    for( HiloMuiltiplicador hilo : hilos ){
      HiloMultiplicacion(this.matriz, this.sigDisponible, this.sigDisponible, this.sigDisponible+rango );
      this.sigDisponible += rango;
    }
  }
}
