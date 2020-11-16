<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Master login Form Responsive Widget Template  :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
<div class="padding-all">
    <div class="header">
        <h1>gym登录</h1>
    </div>

    <div class="design-w3l">
        <div class="mail-form-agile">
            <form action="/ch03/login" method="post">
                <input type="text" name="username" placeholder="用户名" required=""/>
                <input type="password"  name="password" class="padding" placeholder="密码" required=""/>

                <input type="submit" value="登录">
            </form>
        </div>
        <div class="clear" style="color: red">${msg}</div>
    </div>

    <div class="footer">
        <p>© 2020  gym  <a href="login" > boen </a></p>
    </div>
</div>
</body>
</html>