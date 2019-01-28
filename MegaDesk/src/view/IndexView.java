/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Drazen
 */
public class IndexView extends AbstractView {
    
    private static int deskId = 1;
    private static final Random RAND = new Random();

    private int getRandomInt(int min, int max)
    {
        return RAND.nextInt(max - min + 1) + min;
    }
    
    private Map<String, Object> createDesk(List<String> surfaceTypes, 
            List<String> buildTimes)
    {
        Map<String, Object> desk = new HashMap<>();
        desk.put("customer", "Customer " + deskId++);
        desk.put("width", (double)getRandomInt(24, 96));
        desk.put("depth", (double)getRandomInt(12, 48));
        desk.put("drawers", getRandomInt(0, 7));
        
        int i = getRandomInt(0, surfaceTypes.size() - 1);
        desk.put("surface", surfaceTypes.get(i));
        
        i = getRandomInt(0, buildTimes.size() - 1);
        desk.put("buildtime", buildTimes.get(i));
        return desk;
    }

    @Override 
    public void render(Map<String, Object> data) {
        List<String> surfaces = (List<String>)data.get("surfacetypes");
        List<String> buildTimes = (List<String>)data.get("buildtimes");
        
        Map<String, Object> desk = createDesk(surfaces, buildTimes);
        CONTROLLER.handleRequest("orderdesk", desk);
        
        desk = createDesk(surfaces, buildTimes);
        CONTROLLER.handleRequest("orderdesk", desk);
        
        desk = createDesk(surfaces, buildTimes);
        CONTROLLER.handleRequest("orderdesk", desk);
    }
}
