/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import HiloMultiplicacion.HiloMultiplicacion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aguirre
 */
public class MultiplicacionMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrices matrices;
        int fiA, colA, fiB, colB, numHilos;
        int[][] matrizA;
        int[][] matrizB;
        List<Integer> indices = new ArrayList<>();

        System.out.println("filas matriz A: ");
        fiA = sc.nextInt();
        System.out.println("columnas matriz A: ");
        colA = sc.nextInt();
        System.out.println("filas matriz B: ");
        fiB = sc.nextInt();
        System.out.println("columnas matriz B: ");
        colB = sc.nextInt();
        System.out.println("numero de hilos: ");
        numHilos = sc.nextInt();

        matrizA = new int[fiA][colA];
        matrizB = new int[fiB][colB];

        HiloMultiplicacion hiloMulti[numHilos];

        if (colA == fiB) {
            for (int i = 0; i < fiA; i++) {
                for (int j = 0; j < colA; j++) {
                    matrizA[i][j] = (int) (Math.random() * 5);
                }
            }
            for (int i = 0; i < fiB; i++) {
                for (int j = 0; j < colB; j++) {
                    matrizB[i][j] = (int) (Math.random() * 5);
                }
            }
            matrices = new Matrices(matrizA, matrizB);
            int int_identificador = 1;
            for( int hiloNum = 0; hiloNum < numHilos; hiloNum++){
                hiloMulti[hiloNum] = new HiloMultiplicacion(matrices, int_identificador,  );
    	    }
            //hiloMulti = new HiloMultiplicacion(matrices, indices, 0);
            //hiloMulti.start();

            for (int i = 0; i < matrices.getMatA().length; i++) {
                for (int j = 0; j < matrices.getMatA()[0].length; j++) {
                    System.out.print(matrices.getMatA()[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------");
            for (int i = 0; i < matrices.getMatB().length; i++) {
                for (int j = 0; j < matrices.getMatB()[0].length; j++) {
                    System.out.print(matrices.getMatB()[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------");
            for (int i = 0; i < matrices.getRes().length; i++) {
                for (int j = 0; j < matrices.getRes()[0].length; j++) {
                    System.out.print(matrices.getRes()[i][j] + " ");
                }
                System.out.println("");
            }

        } else {
            System.out.println("las matrices no se pueden multiplicar");
        }

    }

}
