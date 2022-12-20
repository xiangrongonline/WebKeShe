package com.java.test;

import com.java.dao.ItemsDAO;
import com.java.entity.Items;

import java.util.ArrayList;

public class testdao {
    public static void main(String[] args) {
        ItemsDAO itemsDAO = new ItemsDAO();
        ArrayList<Items> list = itemsDAO.getAllItems();
        if (list != null && list.size() > 0) for (int i = 0; i < list.size(); i++) {
            Items item = list.get(i);
            System.out.println(item.getName());
        }
    }
}
