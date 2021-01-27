package com.bh.crms.service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.pojo.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();
    public  void addCustomerService(Customer customer){
        customerDao.addCustomer(customer);
    }
    public List<Customer> fillall() {
            return customerDao.fillall();
        }
}