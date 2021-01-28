package com.bh.crms.service;

import com.bh.crms.pojo.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelectServlet", urlPatterns = "/delete")
public class DelectServlet extends HttpServlet {
    private  CustomerService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        customerService.deletecustomer(cid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
        dispatcher.forward(request,response);
    }
}
