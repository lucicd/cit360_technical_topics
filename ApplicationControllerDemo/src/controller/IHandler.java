/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import pojos.Response;

/**
 *
 * @author Drazen
 */
public interface IHandler {
    public Response handleIt(Map<String, Object> data);
}
