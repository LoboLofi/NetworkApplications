/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 *
 * @author aguirre
 */
public class Matrices {

    int[][] matA;
    int[][] matB;
    int[][] res;
    int fiA, colA, fiB, colB;

    public Matrices(int[][] matA, int[][] matB) {
        this.matA = matA;
        this.matB = matB;
        fiA = matA.length;
        colA = matA[0].length;
        fiB = matB.length;
        colB = matB[0].length;
        res = new int[fiA][colB];
    }

    public int[][] getMatA() {
        return matA;
    }

    public void setMatA(int[][] matA) {
        this.matA = matA;
    }

    public int[][] getMatB() {
        return matB;
    }

    public void setMatB(int[][] matB) {
        this.matB = matB;
    }

    public int getFiA() {
        return fiA;
    }

    public void setFiA(int fiA) {
        this.fiA = fiA;
    }

    public int getColA() {
        return colA;
    }

    public void setColA(int colA) {
        this.colA = colA;
    }

    public int getFiB() {
        return fiB;
    }

    public void setFiB(int fiB) {
        this.fiB = fiB;
    }

    public int getColB() {
        return colB;
    }

    public void setColB(int colB) {
        this.colB = colB;
    }

    public int[][] getRes() {
        return res;
    }

    public void setRes(int[][] res) {
        this.res = res;
    }

}
