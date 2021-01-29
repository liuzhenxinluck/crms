package com.bh.crms.dao;

import com.bh.crms.pojo.Customer;
import com.bh.crms.utils.JdbcUtils;
import com.sun.org.apache.xpath.internal.operations.And;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CustomerDao {

    private QueryRunner qr = new QueryRunner();
    //添加数据到数据库
    public void addCustomer(Customer customer) {
        /**
         * 1.sql
         * 2.参数
         */
        String sql = "insert into tb_customer(cid,cname,gender,birthday,cellphone,email,description) values(?,?,?,?,?,?,?)";
        Object[] objects = {
                customer.getCid(),customer.getCname(),
                customer.getGender(), customer.getBirthday(),
                customer.getCellphone(), customer.getEmail(), customer.getDescription()};
        try {
            qr.update(JdbcUtils.getconnection(),sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    //数据查找
    public List<Customer> fillall() {
        String sql = "select * from tb_customer";
        List<Customer> list = null;
        try {
            list = qr.query(JdbcUtils.getconnection(),sql,new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("读取失败！！！！");
        }
        return list;
    }
    //按照cid查找数据库
    public  Customer load(String cid){
        String sql = " select * from tb_customer where cid=?";
        Customer list = null;
        try {
          list=  qr.query(JdbcUtils.getconnection(),sql,new BeanHandler<Customer>(Customer.class),cid);
        } catch (SQLException e) {
           // e.printStackTrace();
            //throw new RuntimeException();
            System.out.println("shibai!!!");
        }
        return list;
    }
        //修改数据
    public void  editCustomer(Customer customer){
    String sql ="UPDATE tb_customer SET cname=?, gender=?, birthday=?, cellphone=?, email=?, description=? WHERE cid=?";
        Object[] objects = {
                customer.getCname(),customer.getGender(),
                customer.getBirthday(), customer.getCellphone(),
                customer.getEmail(), customer.getDescription(),customer.getCid()
        };

        try {
            qr.update(JdbcUtils.getconnection(),sql,objects);
        } catch (SQLException e) {
           // e.printStackTrace();
            throw  new RuntimeException();
        }

    }


    //数据的删除
    public void deleteCurstomer(String cid){
        String sql = "update   tb_customer set ebable=? where cid=?";
        Object[] objects = {1,cid};
        try {
            qr.update(JdbcUtils.getconnection(),sql,objects);
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException();
        }

    }


    //多条件查询
    public List listCustomer(Customer c){
        List<Object> objectList = new ArrayList<>();
          String sql  ="select * from tb_customer where 1=1";

          if (!c.getCname().equals("")){
              sql += " and cname like ?";
              objectList.add("%"+c.getCname().trim()+"%");
          }
          if (!c.getGender().equals("")){
              sql += " and gender like ?";
              objectList.add("%"+c.getGender().trim()+"%");
          }

          if (!c.getCellphone().equals("")){
            sql += " and cellphone like ?";
            objectList.add("%"+c.getCellphone()+"%");
          }

          if (!c.getEmail().equals("")){
            sql += " and email like ?";
            objectList.add("%"+c.getEmail()+"%");
        }
        List<Customer>  list= null;
        try {
           list= qr.query(JdbcUtils.getconnection(),sql,new BeanListHandler<Customer>(Customer.class),objectList.toArray());
        } catch (SQLException e) {
           // e.printStackTrace();
            throw  new RuntimeException();
        }
        return list;

    }
}
