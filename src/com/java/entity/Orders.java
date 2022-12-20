package com.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private String orderId;//订单号。not null  unique
    private int num;//数量
    private float price;//付款金额
    private int state;//0表示未发货  1表示已发货
    private List<OrdersItem> items = new ArrayList<OrdersItem>();//订单中的订单项 //id
    private int userID;       //该订单是属于哪个用户

}
