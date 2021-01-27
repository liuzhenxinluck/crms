package com.bh.crms.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0{

    public void fun() throws SQLException {
        //新建一个ComboPooledDataSource类对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        connection.close();
    }

}
