/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.drazen.controller.person;

import cit360.drazen.controller.Handler;
import cit360.drazen.model.Person;
import cit360.drazen.model.PersonDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aed20672
 */
public class GetPeopleHandler implements Handler {
    
    private static String stringify(List<Person> people) 
            throws JsonProcessingException
    {   
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(people);
        return json;
    }
    
    @Override
    public void handleIt(Map<String, Object> data) {
        try {
            PersonDAO dao = PersonDAO.getInstance();
            List<Person> people = dao.getPeople();
            String json = stringify(people);
            data.put("json", json);
        } catch (JsonProcessingException ex) {
            data.put("error", "Exception: " + ex.getMessage());
        }
    }
    
}
