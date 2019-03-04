package cit360.drazen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownActionHandler implements Handler {
    @Override
    public void handleIt(HttpServletRequest request, 
            HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Unknown action</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Unknown action</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
