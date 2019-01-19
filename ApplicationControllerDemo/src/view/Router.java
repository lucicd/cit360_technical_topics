/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import applicationcontrollerdemo.ApplicationControllerDemo;
import controller.ApplicationController;
import java.util.Map;
import pojos.Request;
import pojos.Response;

/**
 *
 * @author Drazen
 */
public class Router {
    public static void get(String command) {
        get(command, null);
    }
    
    public static void get(String command, Map<String, Object> data) {
        Request request = new Request(command, data);
        Response response  = 
                ApplicationControllerDemo.CONTROLLER.handleRequest(request);
        if (response != null) {
            response.getView().render(response.getData());
        }
    }
}
