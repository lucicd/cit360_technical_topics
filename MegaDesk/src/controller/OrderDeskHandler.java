/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import model.BuildTime;
import model.Desk;
import model.Quotes;
import model.SurfaceType;

/**
 *
 * @author Drazen
 */
public class OrderDeskHandler implements IHandler {

    @Override
    public void handleIt(Controller controller, Map<String, Object> data) {
        String customer = (String)data.get("customer");
        double width = (Double)data.get("width");
        double depth = (Double)data.get("depth");
        int drawers = (Integer)data.get("drawers");
        String surfaceStr = (String)data.get("surface");
        SurfaceType surfaceType = SurfaceType.findByName(surfaceStr);
        String buildTimeStr = (String)data.get("buildtime");
        BuildTime buildTime = BuildTime.findByName(buildTimeStr);
        
        Desk desk = new Desk(width, depth, drawers, 
                customer, buildTime, surfaceType);
        Quotes.add(desk);
        controller.handleRequest("showquotes", null);
    }
    
}
