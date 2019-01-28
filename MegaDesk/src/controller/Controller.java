/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Drazen
 */
public class Controller {
    private final Map<String,IHandler> handlerMap = new HashMap();

    public void handleRequest(String command, Map<String,Object> data){
        IHandler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt(this, data);
        }
    }

    public void mapCommand(String aCommand, IHandler acHandler){
        handlerMap.put(aCommand,acHandler);
    }
}
