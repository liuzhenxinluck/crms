package com.bh.crms.dao;

import com.bh.crms.pojo.Customer;
import com.bh.crms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerDao {
    private QueryRunner qr = new QueryRunner();
    public void addCustomer(Customer customer) {
        /**
         * 1.sql
         * 2.参数
         */
        String sql = "insert into tb_customer values(?,?,?,?,?,?,?)";
        Object[] objects = {customer.getCid(),customer.getCname(), customer.getGender(), customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};
        try {
            qr.update(JdbcUtils.getconnection(),sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

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
}
