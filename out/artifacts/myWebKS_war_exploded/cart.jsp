<%@ page import="com.sun.xml.internal.ws.wsdl.writer.document.Import" %><%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2022/12/7
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.java.entity.Items,com.java.entity.Cart" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/style1.css"/>
    <script language="JavaScript">
        function delcfm() {
            if (!confirm("确认要删除？")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body>
<h1>我的购物车</h1>
<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
<hr>
<div id="shopping">
    <form action="" method="">
        <table>
            <tr>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品价格</th>
                <th>购买数量</th>
                <th>操作</th>
            </tr>
            <%
                //                首先判断session中是否有购物车对象
                if (request.getSession().getAttribute("cart") != null) {
            %>
            <%--  循环的开始          --%>
            <%
                Cart cart = (Cart) request.getSession().getAttribute("cart");
                HashMap<Items, Integer> goods = cart.getGoods();
                Set<Items> items = goods.keySet();
                Iterator<Items> it = items.iterator();

                while (it.hasNext()) {
                    Items i = it.next();
            %>
            <tr name="products" id="product_id_1">
                <td class="thumb"><img src="images/<%=i.getPicture()%>"/><a href=""><%=i.getName()%>
                </a></td>
                <td class="number"><%=i.getPrice()%>
                </td>
                <td class="price" id="price_id_1">
                    <span><%=i.getPrice() * goods.get(i)%></span>
                    <input type="hidden" value=""/>
                </td>
                <td class="number"><%=goods.get(i)%>
                </td>
                <td class="delete">
                    <a href="CartServlet?action=delete&id=<%=i.getId()%>" onclick="delcfm();">删除</a>
                </td>
            </tr>

            <%
                }
            %>
            <%--  循环的结束          --%>

        </table>
        <div class="total"><span id="total">总计：<%=cart.getTotalPrice()%>￥</span></div>
        <%
            }
        %>
        <div class="button"><input type="submit" value=""/></div>
    </form>
</div>
</body>
</html>
