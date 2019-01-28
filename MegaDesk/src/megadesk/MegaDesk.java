/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megadesk;

import controller.*;

/**
 *
 * @author Drazen
 */
public class MegaDesk {

    private static final Controller CONTROLLER = new Controller();
    
    public static Controller getController()
    {
        return CONTROLLER;
    }
    
    public static void main(String[] args) {
        CONTROLLER.mapCommand("index", new HandleIndex());
        CONTROLLER.mapCommand("orderdesk", new OrderDeskHandler());
        CONTROLLER.mapCommand("showquotes", new ShowQuotesHandler());
        CONTROLLER.handleRequest("index", null);
    }
    
}
