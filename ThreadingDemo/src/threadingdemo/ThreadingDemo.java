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
public class ThreadingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimension = Integer.parseInt(args[0]);
        int threads = Integer.parseInt(args[1]);
        test(dimension, threads);
    }
    
    private static void test(int dimension, int threads) {
        System.out.format("Dimension: %d, Threads: %d\n", dimension, threads);
        float[][] matrixA = MatrixCalculator.generateRandom(dimension, dimension);
        float[][] matrixB = MatrixCalculator.generateRandom(dimension, dimension);
        
        long startTime = System.currentTimeMillis();
        float[][] matrixP = MatrixCalculator.multiply(matrixA, matrixB, threads);
        long endTime = System.currentTimeMillis();
        System.out.format("Total execution time 1: %dms\n", endTime - startTime);
        
        startTime = System.currentTimeMillis();
        matrixP = MatrixCalculator.multiply(matrixA, matrixB, threads);
        endTime = System.currentTimeMillis();
        System.out.format("Total execution time 2: %dms\n", endTime - startTime);
    }
    
}
