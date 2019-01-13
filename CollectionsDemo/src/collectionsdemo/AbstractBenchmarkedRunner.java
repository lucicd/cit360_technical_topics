/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsdemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Drazen
 */
public abstract class AbstractBenchmarkedRunner {

    private String description;
    
    public AbstractBenchmarkedRunner(String description) {
        this.description = description;
    }
    
    private List<Integer> makeList(int max) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            myList.add(i);
        }
        
        return myList;
    }
    
    protected abstract int solve(List<Integer> myList);
    
    private int runOnce(List<Integer> myList) {
        return solve(myList);
    }
    
    public void run() {
        System.out.println(this.description);
        List <Integer> myList = makeList(30000);
        long startTime = System.currentTimeMillis();
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result = runOnce(myList);
        }
        System.out.format("The result ist %d.\n", result);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + 
                (endTime-startTime) + "ms\n");
   }
}
