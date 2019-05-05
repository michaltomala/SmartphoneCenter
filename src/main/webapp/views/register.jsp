<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Title</title>

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" />

</head>
<body>

<%@include file="header.jsp"%>

<section class="register">
    <form:form method="post"
               action="${pageContext.request.contextPath}/register"
               modelAttribute="user"
               cssClass="container col-2" >
        <%--<form:errors path="*"  />--%>

        <div class="form-group">
            <form:input path="name" placeholder="login" cssClass="form-input"/>
            <form:errors path="name" cssClass="alert alert-danger" element="div" />
        </div>
        <div class="form-group">
            <form:password path="password" placeholder="password" cssClass="form-input"/>
            <form:errors path="password" cssClass="alert alert-danger" element="div" />
        </div>

        <div class="form-group">
            <form:password path="repeatedPassword" placeholder="password" cssClass="form-input"/>
            <form:errors path="repeatedPassword" cssClass="alert alert-danger" element="div" />
        </div>

        <div class="form-group">
            <c:if test="${not empty errDB}">
                <div class="alert alert-danger">${errDB}</div>
            </c:if>
        </div>
        <input type="submit" value="Zarejestruj" class="btn btn-primary">
    </form:form>
</section>



</body>
</html>