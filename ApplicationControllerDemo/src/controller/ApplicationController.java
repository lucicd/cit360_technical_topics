/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import pojos.Request;
import pojos.Response;

/**
 *
 * @author Drazen
 */
public class ApplicationController {
    private final Map<String, IHandler> handlers;

    public ApplicationController() {
        handlers = new HashMap<>();
        mapCommand("inputBudgetData", new InputDataHandler());
        mapCommand("reportBudget", new CalculateBudgetHandler());
    }
    
    private void mapCommand(String command, IHandler handler) {
        handlers.put(command, handler);
    }
    
    public Response handleRequest(Request request) {
        IHandler commandHandler = handlers.get(request.getCommand());
        if (commandHandler != null) {
            return commandHandler.handleIt(request.getData());
        } else {
            return null;
        }
    }
}
