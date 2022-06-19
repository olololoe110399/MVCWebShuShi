<%--
  Created by IntelliJ IDEA.
  User: nguyenngocduy
  Date: 18.06.22
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Get Properties JSP Page</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.mvcwebshushi.entity.User" scope="application"/>
<h3>
    First Name:
    <jsp:getProperty property="firstName" name="user"/>
    <br/>
    <br/>
    Last Name:
    <jsp:getProperty property="lastName" name="user"/>
</h3>
</body>