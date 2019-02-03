/*
 * Technical topics for CIT360
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import pojos.Request;
import pojos.Response;

/**
 * Contains a standard implementation of the Application Controller pattern.
 * The only changes I made from the book version are this: 
 *    (1) mapCommand method is private, 
 *    (2) handlers are added in the constructor of the controller,  
 *    (3) handleRequest method accepts objects of the Request class as an input, and 
 *    (4) handleRequesat methods returns objects of the Response class. I wanted to mimic the way web applications work.
 * @author Drazen
 */
public class ApplicationController {
    private final Map<String, IHandler> handlers;

    // All handlers are created in the constructor.
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
