package com.gmail.at.rospopa.pavlo.testingsystem.controller;

import com.gmail.at.rospopa.pavlo.testingsystem.service.Service;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", new Service().findAllUsers());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
        if (dispatcher!=null){
            dispatcher.forward(request, response);
        }
    }
}
