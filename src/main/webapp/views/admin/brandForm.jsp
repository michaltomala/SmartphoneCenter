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
    <link rel="stylesheet" href="../../css/style.css" />

</head>
<body>

<%@include file="../header.jsp"%>

<section class="create-Brand-Form">
    <form:form method="post"
               action="${pageContext.request.contextPath}/admin/brand/create"
               modelAttribute="brand"
               cssClass="container col-2" >

        <h2>Dodaj nową Markę</h2>
        <div class="form-group">
            <form:input path="name" placeholder="nazwa" cssClass="form-input"/>
        </div>
        <div class="form-group">
            <c:if test="${not empty brandErr}">
                <div class="alert alert-danger">${brandErr}</div>
            </c:if>
        </div>

        <p class="auth">
            <input type="submit" value="Dodaj" class="btn btn-primary">
        </p>

    </form:form>
</section>



</body>
</html>