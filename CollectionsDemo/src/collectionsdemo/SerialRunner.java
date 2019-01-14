/*
 * The SerialRunner class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package collectionsdemo;

import java.util.List;

/**
 * This runner method will traverse through List
 * by using streaming and lambda expressions
 * @author Drazen
 */
public class SerialRunner extends AbstractBenchmarkedRunner {

    public SerialRunner() {
        super("Serial streaming");
    }

    @Override
    protected int solve(List<Integer> myList) {
        int result = myList.stream()
                .filter(e -> e % 3 == 0 || e % 5 == 0)
                .reduce(0, (a, b) -> a + b);
        return result;
    }
}