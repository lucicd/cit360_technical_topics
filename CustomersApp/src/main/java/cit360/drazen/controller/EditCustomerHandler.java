package cit360.drazen.controller;

import cit360.drazen.exceptions.ModelException;
import cit360.drazen.model.Customer;
import cit360.drazen.model.CustomerDAO;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCustomerHandler implements Handler {
    @Override
    public void handleIt(Map<String, Object> data) {
        try {
            HttpServletRequest request = (HttpServletRequest) data.get("request");
            HttpServletResponse response = (HttpServletResponse)data.get("response");
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/customers/edit.jsp");
            CustomerDAO dao = CustomerDAO.getInstance();
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = dao.getCustomer(id);
            request.setAttribute("customer", customer);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CreateCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ModelException ex) {
            Logger.getLogger(EditCustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
