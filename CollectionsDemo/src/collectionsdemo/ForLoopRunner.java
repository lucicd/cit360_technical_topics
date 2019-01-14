/*
 * The ForLoopRunner class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package collectionsdemo;

import java.util.List;

/**
 * This runner method will traverse through List
 * by using plain for loop.
 * @author Drazen
 */
public class ForLoopRunner extends AbstractBenchmarkedRunner {

    public ForLoopRunner() {
        super("For Loop");
    }

    @Override
    protected int solve(List<Integer> myList) {
        int result = 0;
        for (int i = 0; i < myList.size(); i++) {
            int e = myList.get(i);
            if (e % 3 == 0 || e % 5 == 0) {
                result += e;
            }
        }
        return result;
    }
}
