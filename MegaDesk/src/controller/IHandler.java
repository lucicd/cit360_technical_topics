/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;

/**
 *
 * @author Drazen
 */
public interface IHandler {
    
    public void handleIt(Controller controller, Map<String, Object> data);
}
