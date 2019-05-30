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
    <div class="create-Phone-SecondForm">
    <form:form method="post"
               action="${pageContext.request.contextPath}/admin/phone/create/secondStep"
               modelAttribute="phoneDetails"
               cssClass="container col-2" >

        <h2 class="phoneForm">Dodaj nowy Smartphone 2/2</h2>

        <c:if test="${not empty flagshipErr}"><div class="alert alert-danger">${flagshipErr}</div></c:if>

        <div class="create-Phone-Buttons">
            <div class="form-group">
                <button type="button" class="btn btn-secondary btn-lg" disabled>Flagowiec</button>
                <form:radiobutton path="isFlagship" value="true" class="btn btn-outline-success"></form:radiobutton>
                <label class="form-check-label" >Tak</label>
                <form:radiobutton path="isFlagship" value="false" class="btn btn-outline-dark"></form:radiobutton>
                <label class="form-check-label" >Nie</label>
            </div>
        </div>
        <div class="create-Phone-Buttons">
            <div class="form-group">
                <button type="button" class="btn btn-secondary btn-lg" disabled>ExFlagowiec</button>
                <form:radiobutton path="isExFlagship" value="true"></form:radiobutton>
                <label class="form-check-label" >Tak</label>
                <form:radiobutton path="isExFlagship" value="false"></form:radiobutton>
                <label class="form-check-label" >Nie</label>
            </div>
        </div>
        <div class="create-Phone-Buttons">
            <div class="form-group">
                <button type="button" class="btn btn-secondary btn-lg" disabled>NFC</button>
                <form:radiobutton path="nfc" value="true"></form:radiobutton>
                <label class="form-check-label" >Tak</label>
                <form:radiobutton path="nfc" value="false"></form:radiobutton>
                <label class="form-check-label" >Nie</label>
            </div>
        </div>

        <p class="create-phone-form">
            <input type="submit" value="Dodaj" class="btn btn-primary">
        </p>

    </form:form>
    </div>
</section>



</body>
</html>