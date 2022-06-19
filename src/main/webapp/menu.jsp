<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu Page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link href="css/detail.css" rel="stylesheet" type="text/css"/>
    <link href="css/container.css" rel="stylesheet" type="text/css"/>
    <link href="css/header.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    <link href="css/menu.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrap">
    <%@include file="includes/header.jsp" %>
    <div class="content">
        <div class="main-content">
            <div class="content-left">
                <div class="img-border">
                    <img src="image/kinmadai_banner_ngang_a67d08e7ef0b4efaad32e842207daff1_grande.jpeg" alt=""/>
                </div>
                <c:if test="${not empty noContent}">
                    <h3>${noContent}</h3>
                </c:if>
                <c:if test="${empty noContent}">
                    <c:forEach var="i" items="${content}">
                        <div class="border-post">
                            <div class="post">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Menu ${i.getId()}</th>
                                        <th class="align-right">Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>${i.getName()}</th>
                                        <th class="align-right">€${i.getPrice()}</th>
                                    </tr>
                                    </tbody>
                                </table>
                                <p>${i.getContent()}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <div class="paging">
                    <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                        <c:if test="${page != j}">
                            <a href="menu-controller?page=${j}">${j}</a> |
                        </c:if>
                        <c:if test="${page == j}">
                            ${j} |
                        </c:if>
                    </c:forEach>.
                </div>
            </div>
            <%@include file="includes/container.jsp" %>
        </div>
        <%@include file="includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
