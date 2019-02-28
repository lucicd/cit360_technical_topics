/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.drazen.controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Drazen
 */
public class CustomerController 
{
    private final Map<String,Handler> handlerMap = new HashMap();
    
    private static CustomerController singleInstance = null;
    
    private CustomerController()
    {
        mapCommand("list", new GetCustomersHandler());
        mapCommand("create", new CreateCustomerHandler());
        mapCommand("edit", new EditCustomerHandler());
    }
    
    public static CustomerController getInstance()
    {
        if (singleInstance == null)
        {
            singleInstance = new CustomerController();
        }
        return singleInstance;
    }

    public void handleRequest(String command, Map<String, Object> data)
    {
        Handler aCommandHandler = 
                handlerMap.get(command == null ? "list" : command);
        if (aCommandHandler == null)
        {
            aCommandHandler = new UnknownCommandHandler();
        } 
        aCommandHandler.handleIt(data);
    }

    private void mapCommand(String aCommand, Handler acHandler)
    {
        handlerMap.put(aCommand, acHandler);
    }
}
