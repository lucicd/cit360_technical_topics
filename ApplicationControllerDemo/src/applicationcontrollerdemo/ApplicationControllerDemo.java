/*
 * Technical topics for CIT360
 * Demo project to calculate monthly budget. 
 * Uses application controller patttern
 */
package applicationcontrollerdemo;

import controller.*;
import view.Router;

/**
 *
 * @author Drazen
 */
public class ApplicationControllerDemo {

    /**
     * Holds a reference to the application controller object
     */
    public static final ApplicationController CONTROLLER = 
            new ApplicationController();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Router.get("inputBudgetData");
    }
    
}
