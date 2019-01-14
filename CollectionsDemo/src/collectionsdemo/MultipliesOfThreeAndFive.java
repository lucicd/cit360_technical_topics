/*
 * The MultipliesOfThreeAndFive class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */

package collectionsdemo;
/**
 * Invokes four runners to demonstrate differences between
 * methods of traversing through the elements of a List collection classes.
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