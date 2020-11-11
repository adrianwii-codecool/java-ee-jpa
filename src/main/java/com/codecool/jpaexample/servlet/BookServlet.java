package com.codecool.jpaexample.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",  urlPatterns = {"/users", "/users/*"})
public class UserServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }
}
