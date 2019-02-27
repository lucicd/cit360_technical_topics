package cit360.drazen.controller;

import cit360.drazen.exceptions.ModelException;
import cit360.drazen.model.Customer;
import cit360.drazen.model.CustomerDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCustomersHandler implements Handler {
    
    @Override
    public void handleIt(Map<String, Object> data) {
        try {
            HttpServletRequest request = (HttpServletRequest)data.get("request");
            HttpServletResponse response = (HttpServletResponse)data.get("response");

            CustomerDAO dao = CustomerDAO.getInstance();
            List<Customer> customers = dao.getCustomers();
            request.setAttribute("customers", customers);

            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/customers.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException | ModelException ex) {
            Logger.getLogger(GetCustomersHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
