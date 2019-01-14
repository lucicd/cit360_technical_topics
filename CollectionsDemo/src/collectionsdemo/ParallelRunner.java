/*
 * The ParallelRunner class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package collectionsdemo;

import java.util.List;

/**
 * This runner method will traverse through List
 * by using parallel streaming and lambda expressions.
 * 
 * @author Drazen
 */
public class ParallelRunner extends AbstractBenchmarkedRunner {

    public ParallelRunner() {
        super("Parallel streaming");
    }

    @Override
    protected int solve(List<Integer> myList) {
        int result = myList.parallelStream()
                .filter(e -> e % 3 == 0 || e % 5 == 0)
                .reduce(0, (a, b) -> a + b);
        return result;
    }
}