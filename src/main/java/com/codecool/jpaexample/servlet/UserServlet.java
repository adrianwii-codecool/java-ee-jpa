package com.codecool.jpaexample.servlet;

import com.codecool.jpaexample.dao.UserDao;
import com.codecool.jpaexample.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet",  urlPatterns = {"/users", "/users/*"})
public class UserServlet extends HttpServlet {

    //mapper from jackson dependency, include it in pom.xml
    ObjectMapper mapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        //TODO here you can check URL, if include id, then return single Object, if not, return List of objects
        UserDao userDao = new UserDao();
        List<User> users =  userDao.getUsers();
        System.out.println(users);
        out.print(mapper.writeValueAsString(users));
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        //TODO
    }
}
