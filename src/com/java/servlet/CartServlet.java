package com.java.servlet;

import com.java.dao.ItemsDAO;
import com.java.entity.Cart;
import com.java.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    private String action;//表示购物车的动作
    private ItemsDAO idao = new ItemsDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
            if (action.equals("add")) if (addToCart(request, response))
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            else
                request.getRequestDispatcher("/failure.jsp").forward(request, response);
            if (action.equals("show")) request.getRequestDispatcher("/cart.jsp").forward(request, response);
            if (action.equals("delete")) {
                if (deleteFromCart(request, response)) {
                    request.getRequestDispatcher("/cart.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/cart.jsp").forward(request, response);
                }
            }
        }
    }

    //添加商品进购物车
    private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String number = request.getParameter("num");
        Items item = idao.getItemsById(Integer.parseInt(id));

        if (request.getSession().getAttribute("cart") == null) {
            Cart cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart.addGoodsInCart(item, Integer.parseInt(number))) return true;
        else return false;
    }

    private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Items item = idao.getItemsById(Integer.parseInt(id));
        return cart.removeGoodsFromCart(item);
    }
}
