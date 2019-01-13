/*
 * PROBLEM:
 * If we list all natural numbers below 10 that are multiplies of
 * 3 or 5, we get 3, 5, 6, and 9. The sum of these multiplies is 23.
 * Find the sum of all the mutiplies of 3 and 5 below given number N.
 */
package collectionsdemo;

/**
 *
 * @author Drazen
 */
public class MultipliesOfThreeAndFive {
   
    public static void run() {
        new ParallelRunner().run();
        new SerialRunner().run();
        new ForEachLoopRunner().run();
        new ForLoopRunner().run();
    }
}