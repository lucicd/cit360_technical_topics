/*
 * The ForEachLoopRunner class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package collectionsdemo;

import java.util.List;

/**
 * This runner method will traverse through List
 * by using for-each loop.
 * 
 * @author Drazen
 */
public class ForEachLoopRunner extends AbstractBenchmarkedRunner {

    public ForEachLoopRunner() {
        super("For-Each Loop");
    }
    

    @Override
    protected int solve(List<Integer> myList) {
        int result = 0; 
        for (Integer e: myList) {
            if (e % 3 == 0 || e % 5 == 0) {
                result += e;
            }
        }
        return result;
    }
}
