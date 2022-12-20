package com.java.dao;

import com.java.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public int userTypeAdd(Connection con, User userType) throws Exception {
        String sql = "insert into user(usernumber, userpassword) values(?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, userType.getUsernumber());
        pstmt.setString(2, userType.getUserpassword());
        return pstmt.executeUpdate();
    }

    public User loqin(Connection con, User user) throws Exception {
        User resultUser = null;
        String sql = "select * from user where usernumber = ? and userpassword = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUsernumber());
        pstmt.setString(2, user.getUserpassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setUsernumber(rs.getString("usernumber"));
            resultUser.setUserpassword(rs.getString("userpassword"));
        }
        return resultUser;
    }

    public boolean isHaveUser(Connection con, String name) throws Exception {
        String sql = "select * from user where usernumber = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
}
