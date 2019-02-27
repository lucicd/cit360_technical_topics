package cit360.drazen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommandHandler implements Handler {
    @Override
    public void handleIt(Map<String, Object> data) {
        HttpServletResponse response = (HttpServletResponse)data.get("response");
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
