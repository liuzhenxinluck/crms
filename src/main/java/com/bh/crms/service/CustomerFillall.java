package com.bh.crms.service;

import com.bh.crms.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "fillall" , urlPatterns = "/fillall")
public class CustomerFillall extends HttpServlet {

            private  CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.接受前端的传输数据
         * 2.把数据进行封装
         * 3.接受后端的书局保存到request域中
         * 4.跳转页面
         */
        //super.doGet(req, resp);
            List<Customer> list = customerService.fillall();
            req.setAttribute("custom",list);
            RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
            dispatcher.forward(req,resp);

    }
}
