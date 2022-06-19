<%--
  Created by IntelliJ IDEA.
  User: nguyenngocduy
  Date: 19.06.22
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Error Page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrap">
    <%@include file="includes/header.jsp" %>
    <div class="content">
        <div class="main-content">
            <div class="content-left">
                <h3>Error !!! Please click <a
                        href="home-controller">here</a> to go back home page.</h3>
            </div>
            <%@include file="includes/container.jsp" %>
        </div>
        <div class="footer">
            <a href="#">Created with SimpleSite</a>
            <span>0 2 5 5 5 3</span>
        </div>
    </div>

</div>
</body>
