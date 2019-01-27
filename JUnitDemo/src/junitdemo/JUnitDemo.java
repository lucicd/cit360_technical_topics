/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitdemo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Drazen
 */
public class JUnitDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static boolean alwaysTrue()
    {
        return true;
    }
    
    public static String[] q1Months()
    {
        String[] months = {"Jan", "Feb", "Mar"};
        return months;
    }
    
    public static int fact(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else
        {
            return n * fact(n - 1);
        }
    }
    
    public static boolean greaterThan(int a, int b)
    {
        return a > b;
    }
    
    public static String getDay(int day)
    {
        Map<Integer, String> days = new HashMap<>();
        days.put(1, "Sunday");
        days.put(2, "Monday");
        days.put(3, "Tuesday");
        days.put(4, "Wednesday");
        days.put(5, "Thursday");
        days.put(6, "Friday");
        days.put(7, "Saturday");
        
        return days.get(day);
    }
    
    
}
