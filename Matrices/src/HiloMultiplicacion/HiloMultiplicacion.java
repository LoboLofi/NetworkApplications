/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package HiloMultiplicacion;

import java.util.List;
import multiplicacionmatrices.Matrices;

/**
*
* @author aguirre
*/
public class HiloMultiplicacion extends Thread {

  Matrices matrices;
  List<Integer> indices;
  int m_ini, m_fin;


  public HiloMultiplicacion(Matrices matrices, int id, int m_ini, int m_fin ) {
    this.matrices = matrices;
    this.indices = indices;
    this.m_ini = m_ini;
    this.m_fin = m_fin;

    Thread.currentThread().setName("Hilo_Mult_" + id);
  }

  @Override
  public void run() {
    for (int x = this.m_ini; x < this.m_fin; x++) {
      for (int y = this.m_ini; y < this.m_fin; y++) {
        for (int z = 0; z < matrices.getColA(); z++) {
          matrices.getRes()[x][y] += matrices.getMatA()[x][z] * matrices.getMatB()[z][y];
        }
      }
    }
  }

}
