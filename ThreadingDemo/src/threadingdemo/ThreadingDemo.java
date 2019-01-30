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
    
    private static void reportPerformance(int pass, 
            long startTime, long endTime, int dimension)
    {
        System.out.format("Total execution time %d: %dms\n", pass, endTime - startTime);
        long n = dimension;
        long operations = (2 * n - 1) * n * n;
        System.out.format("Number of operations: %,d\n", operations);
        double performance = operations / (endTime - startTime) * 1000;
        System.out.format("Performance: %,.2f GFLOPS\n\n", performance / 1e9);
        
    }
    
    private static void test(int dimension, int threads)
    {
        System.out.format("Dimension: %d, Threads: %d\n\n", dimension, threads);
        float[][] matrixA = MatrixCalculator.generateRandom(dimension, dimension);
        float[][] matrixB = MatrixCalculator.generateRandom(dimension, dimension);
        
        long startTime = System.currentTimeMillis();
        float[][] matrixP = MatrixCalculator.multiply(matrixA, matrixB, threads);
        long endTime = System.currentTimeMillis();
        reportPerformance(1, startTime, endTime, dimension);
        
        startTime = System.currentTimeMillis();
        matrixP = MatrixCalculator.multiply(matrixA, matrixB, threads);
        endTime = System.currentTimeMillis();
        reportPerformance(2, startTime, endTime, dimension);
    }
}
