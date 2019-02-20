/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.drazen.controller;

import cit360.drazen.exceptions.ModelException;
import cit360.drazen.model.Customer;
import cit360.drazen.model.CustomerDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aed20672
 */
public class GetCustomersHandler implements Handler {
    
    private static String stringify(List<Customer> customers) 
            throws JsonProcessingException
    {   
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customers);
        return json;
    }
    
    @Override
    public void handleIt(Map<String, Object> data) {
        try {
            CustomerDAO dao = CustomerDAO.getInstance();
            List<Customer> customers = dao.getCustomers();
            String json = stringify(customers);
            data.put("json", json);
        } catch (JsonProcessingException | ModelException ex) {
            data.put("error", "Exception: " + ex.getMessage());
        } 
    }
}
