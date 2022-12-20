package com.java.servlet;

import com.java.dao.UserDAO;
import com.java.entity.User;
import com.java.util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "ZCServlet", value = "/ZCServlet")
public class ZCServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private Connection conn = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        //获得请求参数
        String name = request.getParameter("username");
        String psd1 = request.getParameter("password1");
        String psd2 = request.getParameter("password2");
        if (name.equals("") || name == null || psd1.equals("") || psd1 == null || psd2.equals("") || psd2 == null || !psd1.equals(psd2)) {
            out.println("<script>alert('用户名或密码不符合规范，请重新输入');</script>");
            request.getRequestDispatcher("/zhuce.jsp").include(request, response);
        } else {
            User user = new User(name, psd1);
            conn = DBHelper.getConn();
            try {
                if (userDAO.isHaveUser(conn, name)) {
                    out.println("<script>alert('用户名已被注册，请重新输入');</script>");
                    request.getRequestDispatcher("/zhuce.jsp").include(request, response);
                } else {
                    userDAO.userTypeAdd(conn, user);
                    out.println("<script>alert('注册成功，转到登陆界面');</script>");
                    request.getRequestDispatcher("/login.jsp").include(request, response);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                DBHelper.closeAll(conn, null, null);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
