<%--
  Created by IntelliJ IDEA.
  User: nguyenngocduy
  Date: 18.06.22
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Set Properties JSP Page</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.mvcwebshushi.entity.User" scope="application"/>
<jsp:setProperty property="firstName" name="user" value="NewPerson"/>
<jsp:setProperty property="lastName" name="user" value="Nguyen"/>
</body>
</html>
