/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontrollerdemo;

import controller.*;
import view.Router;

/**
 *
 * @author Drazen
 */
public class ApplicationControllerDemo {

    public static final ApplicationController CONTROLLER = 
            new ApplicationController();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Router.get("inputBudgetData");
    }
    
}
