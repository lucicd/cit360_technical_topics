/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadingdemo;

/**
 *
 * @author Drazen
 */
public class CalcOneElement implements Runnable {

    public CalcOneElement(float[][] matrixP, float[][] matrixA, float[][] matrixB, 
            int rowA, int columnB) {
        this.matrixP = matrixP;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rowA = rowA;
        this.columnB = columnB;
    }
    
    private final float[][] matrixP;
    private final float[][] matrixA;
    private final int rowA;
    private final float[][] matrixB;
    private final int columnB;

    private float result;

    public float getResult() {
        return result;
    }

    @Override
    public void run() {
        int length = matrixA[rowA].length;
        result = 0;
        for (int i = 0; i < length; i++) {
            result += matrixA[rowA][i] * matrixB[i][columnB];
        }
        matrixP[rowA][columnB] = result;
    }
}
