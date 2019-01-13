/*
 * The AbstractBenchmarkRunner class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package collectionsdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class used by runner classes
 * to implement various methods of iterating through
 * an ArrayList collection
 * @author Drazen
 */
public abstract class AbstractBenchmarkedRunner {

    // Description of the concrete runner class.
    // It is used only for 'cosmetic' purpose, that is,
    // the description will be printed in the report.
    private final String description;
    
    /**
     * Public constructor of the AbstractBenchmarkedRunner class
     * Sets the description attribute.
     * @param description 
     */
    public AbstractBenchmarkedRunner(String description) {
        this.description = description;
    }
    
    // Creates a list of integer numbers from 1 up to the
    // given max value but excluding the max value.
    private List<Integer> makeList(int max) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            myList.add(i);
        }
        
        return myList;
    }
    
    // Abstract method that will be implemented in various concrete runners.
    // There are four runners that use different iteration methods:
    // SerialRunner, ParallelRunner, ForLoopRunner, and For EachLoopRunner.
    protected abstract int solve(List<Integer> myList);
    
    // Runs one cycle of solve method.
    // The number of cycles can be changed.
    private int runOnce(List<Integer> myList) {
        return solve(myList);
    }
    
    // Template method to run solve cycles for concrete runners.
    public void run() {
        // Print runner description
        System.out.println(this.description);
        
        // Create a list of integers
        List <Integer> myList = makeList(30000);
        
        // Record starting time, for benchmarking
        long startTime = System.currentTimeMillis();
        
        // Execute 1000 solve syscles, to accumlate some time
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            result = runOnce(myList);
        }
        // Record ending time 
        long endTime = System.currentTimeMillis();
        
        // Show the result and the execution time 
        System.out.format("The result is %d.\n", result);
        System.out.println("Total execution time: " + 
                (endTime-startTime) + "ms\n");
   }
}
