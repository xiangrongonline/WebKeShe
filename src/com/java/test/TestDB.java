package com.java.test;

import com.java.util.DBHelper;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DBHelper.getConn();
            if (connection != null) {
                System.out.println("数据库连接正常！");
            } else {
                System.out.println("数据库连接异常！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
