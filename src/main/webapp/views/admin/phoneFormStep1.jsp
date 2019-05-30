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
    <link rel="stylesheet" href="/css/style.css" />

</head>
<body>

<%@include file="../header.jsp"%>

<section class="create-Phone-Form">
    <form:form method="post"
               action="${formAction}"
               modelAttribute="phone"
               cssClass="container col-2" >

        <c:if test="${empty phone.id}"><h2 class="phoneForm">Dodaj nowy Smartphone 1/2</h2></c:if>
        <c:if test="${not empty phone.id}"><h2 class="phoneForm">Edytuj Smartphone 1/2</h2></c:if>

        <div class="form-group">
            <label class="brandLabel">Marka</label>
            <form:select path="brand"  class="form-control">
                    <c:if test="${not empty phone.brand}">
                        <option value="${phone.brand.id}" >${phone.brand.name}</option>
                    </c:if>
                    <c:if test="${empty phone.brand}">
                        <option value="0" >Wybierz -</option>
                    </c:if>
                <c:forEach items="${brands}" var="brand">
                    <form:option value="${brand.id}">${brand.name}</form:option>
                </c:forEach>
            </form:select>
            <c:if test="${not empty brandErr}">
                <div class="alert alert-danger">Musisz wybrać markę!</div>
            </c:if>
        </div>

        <div class="form-group col-md-6">
            <label>Nazwa</label>
            <form:input path="name" placeholder="Nazwa" cssClass="form-input"/>
        </div>
        <c:if test="${not empty phoneErr}">
            <div class="alert alert-danger">Nazwa musi być unikalna i niepusta!</div>
        </c:if>

        <div class="form-group col-md-6">
            <label>
                Cena:
                <form:input path="price" type="number" step="100" min="299" max="10000"/>
            </label>
            <c:if test="${not empty priceErr}">
                <div class="alert alert-danger">Cena musi być z zakresu od 299 do 10000!</div>
            </c:if>
        </div>

        <div class="form-group col-md-6">
            <label>CeneoLink</label>
            <form:input path="ceneoUrl" placeholder="Link do Ceneo" cssClass="form-input"/>
        </div>
        <c:if test="${not empty LinkErr}">
            <div class="alert alert-danger">Nieprawidłowy lub pusty link!</div>
        </c:if>

        <p class="create-phone-form">
            <input type="submit" value="Dodaj" class="btn btn-primary">
        </p>

    </form:form>
</section>



</body>
</html>