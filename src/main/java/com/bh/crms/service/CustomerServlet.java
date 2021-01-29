package com.bh.crms.service;

import com.bh.crms.pojo.Customer;
import com.bh.crms.utils.DateUtils;
import com.bh.crms.utils.Uuidutils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "customer",urlPatterns = "/web")
public class CustomerServlet extends HttpServlet {
        private CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //super.doPost(req, resp);
        try {
            /**
             * 1.接受前端的传输数据
             * 2.把数据进行封装
             * 3.接受后端的书局保存到request域中
             * 4.跳转页面
             */
        Customer customer= new Customer();
        String cid = Uuidutils.UUid();
        String name = req.getParameter("cname");
        String  gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        Date newbirthday = null;
        newbirthday = DateUtils.format3(birthday,"yy-MM-dd");
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        String description = req.getParameter("description");

        Customer c = new Customer(cid,name,gender,newbirthday,cellphone,email,description);
        customerService.addCustomerService(c);
            ServletContext servletContext = this.getServletContext();
            servletContext.setAttribute("msg","添加数据成功!!!!");
           // resp.sendRedirect("msg.jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("msg.jsp");
            dispatcher.forward(req,resp);
        } catch (ParseException e) {
            System.out.println("转换失败！");
        }

    }
}
