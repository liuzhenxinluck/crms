package com.bh.crms.service;

import com.bh.crms.pojo.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "edits",urlPatterns = "/editservlet")
public class EditServlet extends HttpServlet {
            private  CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        /**
         * 1.接受数据
         * 2.根据cid的查询
         * 调用方法
         * 3.保存信息到request域
         * 4.跳转页面
         */
        String cid=req.getParameter("cid");
        Customer list = customerService.load(cid);
        req.setAttribute("custom",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
