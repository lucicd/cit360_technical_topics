package cit360.drazen.controller;

import cit360.drazen.exceptions.ModelException;
import cit360.drazen.model.Customer;
import cit360.drazen.model.CustomerDAO;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

public class InsertCustomerHandler implements Handler {

    @Override
    public void handleIt(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = CustomerHelpers.createCustomer(request);
        Set<ConstraintViolation<Customer>> violations = CustomerHelpers.validate(customer);
        if (violations.isEmpty()) {
            CustomerDAO dao = CustomerDAO.getInstance();
            try {
                Integer id = dao.addCustomer(customer);
                request.setAttribute("id", id);
                CustomerController.getInstance()
                        .handleRequest("list", request, response);
            } catch (ModelException ex) {
                Logger.getLogger(InsertCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("violations", violations);
            request.setAttribute("customer", customer);
            CustomerController.getInstance()
                    .handleRequest("create", request, response);
        }
    }
}
