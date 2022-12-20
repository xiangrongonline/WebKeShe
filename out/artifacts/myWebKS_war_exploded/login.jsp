<%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2022/12/14
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆页面</title>
    <style>
        body {
            background: url('images/beijing1.jpg') no-repeat;
            background-size: 100% auto;
        }

        #login_box {
            width: 20%;
            height: 400px;
            background-color: #00000060;
            margin: auto;
            margin-top: 10%;
            text-align: center;
            border-radius: 10px;
            padding: 50px 50px;
        }

        #login_box input,
        #login_box button {
            outline: none;
        }

        #login_box h2 {
            color: #ffffff90;
            margin-top: 5%;
        }

        #login_box #form #input_box {
            margin-top: 5%;
        }

        #login_box #form #input_box input {
            border: 0;
            width: 60%;
            font-size: 15px;
            color: #ffffff;
            background: #ffffff00;
            border-bottom: 2px solid #ffffff;
            padding: 5px 10px;
            margin-top: 10px;
        }

        #login_box button {
            margin-top: 50px;
            width: 40%;
            height: 20px;
            border-radius: 10px;
            border: 0;
            color: #fff;
            font-size: 15px;
            background-image: linear-gradient(120deg, #f093fb 0%, #f5576c 100%);
            cursor: pointer;
        }

        #login_box #sign_up {
            margin-top: 45%;
        }

        #login_box #sign_up a {
            color: #b94648;
        }

        input::-webkit-input-placeholder {
            color: lightskyblue;
        }
    </style>
</head>
<body>
<form action="DLServlet" method="GET">
    <div id="login_box">
        <h2>登录</h2>
        <div id="form">
            <div id="input_box">
                <input type="text" name="username" placeholder="请输入用户名">
            </div>
            <div id="input_box">
                <input type="password" name="password" placeholder="请输入密码">
            </div>
            <div id="input_box">
                <img src="CheckServ"><br>
                <input type="text" name="checkname" placeholder="请输入验证码">
            </div>
        </div>
        <button id="sign_in">登录</button>
        <br>
        <br>
        还没有账号？<a href="zhuce.jsp">注册用户</a>
    </div>
</form>
</body>
</html>
