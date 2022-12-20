package com.java.servlet;

import com.java.dao.UserDAO;
import com.java.entity.User;
import com.java.util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DLServlet", value = "/DLServlet")
public class DLServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private Connection conn = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        //获得请求参数
        String name = request.getParameter("username");
        String psd = request.getParameter("password");
        //1验证验证码
        //获取用户输入的验证码
        String code = request.getParameter("checkname");
        //取得 session存的验证码
        HttpSession session = request.getSession();
        HttpSession session2 = request.getSession();
        String code2 = (String) session.getAttribute("checkcode");
        //如果不相等则返回登陆页面
        if (code2.equals(code)) {
            try {
                User user = new User(name, psd);
                conn = DBHelper.getConn();
                if (userDAO.loqin(conn, user) != null) {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    out.println("<script>alert('用户名或密码错误，请重新输入');</script>");
                    request.getRequestDispatcher("/login.jsp").include(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                DBHelper.closeAll(conn, null, null);
            }
        } else {
            out.println("<script>alert('验证码错误，请重新输入');</script>");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
