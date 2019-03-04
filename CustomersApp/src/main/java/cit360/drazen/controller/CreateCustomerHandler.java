package cit360.drazen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCustomerHandler implements Handler {

    @Override
    public void handleIt(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/customers/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            try (PrintWriter out = response.getWriter()) {
                out.print(ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(CreateCustomerHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
