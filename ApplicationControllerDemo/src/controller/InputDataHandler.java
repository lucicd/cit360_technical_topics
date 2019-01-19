/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import pojos.Response;
import view.InputDataView;

/**
 *
 * @author Drazen
 */
public class InputDataHandler implements IHandler {

    @Override
    public Response handleIt(Map<String, Object> data) {
        Response response = new Response(new InputDataView());
        return response;
    }
    
}
