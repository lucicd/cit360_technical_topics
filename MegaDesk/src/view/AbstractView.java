/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.Map;
import megadesk.MegaDesk;

/**
 *
 * @author Drazen
 */
public abstract class AbstractView {
    protected static final Controller CONTROLLER = MegaDesk.getController();
    
    public abstract void render(Map<String, Object> data);
}
