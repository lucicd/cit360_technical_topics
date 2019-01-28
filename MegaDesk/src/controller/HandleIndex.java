/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import model.BuildTime;
import model.SurfaceType;
import view.AbstractView;
import view.IndexView;

/**
 *
 * @author Drazen
 */
public class HandleIndex implements IHandler {

    @Override
    public void handleIt(Controller controller, Map<String, Object> data) {
        Map<String, Object> viewData = new HashMap<>();
        viewData.put("surfacetypes", SurfaceType.getNames());
        viewData.put("buildtimes", BuildTime.getNames());
        AbstractView view = new IndexView();
        view.render(viewData);
    }
    
}
