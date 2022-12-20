package com.java.dao;

import com.java.entity.Items;
import com.java.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemsDAO {
    //获得所有的商品信息
    public ArrayList<Items> getAllItems() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Items> list = new ArrayList<Items>();
        try {
            conn = DBHelper.getConn();
            String sql = "select * from items;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setNumber(rs.getInt("number"));
                item.setPrice(rs.getInt("price"));
                item.setPicture(rs.getString("picture"));
                list.add(item);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (rs != null) try {
                rs.close();
                rs = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
                stmt = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //根据商品编号获得商品资料
    public Items getItemsById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConn();
            String sql = "select * from items where id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Items item = new Items();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCity(rs.getString("city"));
                item.setNumber(rs.getInt("number"));
                item.setPrice(rs.getInt("price"));
                item.setPicture(rs.getString("picture"));
                return item;
            } else return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (rs != null) try {
                rs.close();
                rs = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
                stmt = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Items> getViewList(String list) {
        ArrayList<Items> itemlist = new ArrayList<Items>();
        int iCount = 5;
        if (list != null && list.length() > 0) {
            String[] arr = list.split(",");

            if (arr.length >= 5)
                for (int i = arr.length - 1; i >= arr.length - iCount; i--)
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
            else for (int i = arr.length - 1; i > 0; i--) itemlist.add(getItemsById(Integer.parseInt(arr[i])));
            return itemlist;
        } else return null;
    }
}
