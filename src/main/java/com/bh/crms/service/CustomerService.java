package com.bh.crms.service;

import com.bh.crms.dao.CustomerDao;
import com.bh.crms.pojo.Customer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@Service
public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();


    //添加数据
    public  void addCustomerService(Customer customer){

        customerDao.addCustomer(customer);
    }
    //查找数据
    public List<Customer> fillall() {
            return customerDao.fillall();
        }
    //按照cid查找数据
    public  Customer  load(String cid){
        return customerDao.load(cid);
    }
    //修改数据
    public void  editCustomer(Customer customer){
        customerDao.editCustomer(customer);
    }
    //数据的删除
    public void deletecustomer(String cid){
        customerDao.deleteCurstomer(cid);
    }
    //多条件查询
    public List<Customer> listAll(Customer customer) {
        return customerDao.listCustomer(customer);
    }
}