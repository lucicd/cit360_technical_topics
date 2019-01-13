/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsdemo;

import java.util.List;

/**
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
