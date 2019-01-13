
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