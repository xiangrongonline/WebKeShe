<%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2022/12/7
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加成功</title>
</head>
<body>
<center>
    <img src="images/add_cart_success.jpg"/>
    <hr>
    <%
        String id = request.getParameter("id");
        String num = request.getParameter("num");
    %>
    您成功购买了<%=num%>件商品编号为<%=id%>的商品&nbsp;&nbsp;&nbsp;&nbsp;
    <br>
    <br>
    <br>

</center>
</body>
</html>
