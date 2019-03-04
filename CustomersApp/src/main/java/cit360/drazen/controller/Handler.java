package cit360.drazen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
    public void handleIt(HttpServletRequest request, HttpServletResponse response);
}