package com.bh.crms.service;

import com.bh.crms.pojo.Customer;
import com.bh.crms.utils.DateUtils;

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

@WebServlet(name = "EditsServlet",urlPatterns = "/edit")
public class EditsServlet extends HttpServlet {
    private CustomerService service =new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**
 *
 */
        try {
            String cid = request.getParameter("cid");
            String cname = request.getParameter("cname");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            Date newbirthday = DateUtils.format3(birthday,"yy-MM-dd");
            String cellphone = request.getParameter("cellphone");
            String email = request.getParameter("email");
            String description = request.getParameter("description");
            Customer customer = new Customer();
            Customer c = new Customer(cid,cname,gender,newbirthday,cellphone,email,description);
            service.editCustomer(c);
            ServletContext servletContext = this.getServletContext();
            servletContext.setAttribute("msg","修改成功！！");
            RequestDispatcher dispatcher = request.getRequestDispatcher("msg.jsp");
            dispatcher.forward(request,response);
        }catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("转化日期失败！！！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
