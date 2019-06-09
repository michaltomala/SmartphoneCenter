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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css" />

    <style>
        div.album.py-5.bg-light{
            background-image:linear-gradient( white 5%, #a3a4b8, rgba(110, 107, 147, 0.86));
            width: 100%;
            height: 100%;
        }
        img{
        width: 425px;
        height: 285px;
        }
    </style>

</head>
<body>


<%@include file="../header.jsp"%>

<div class="album py-5 bg-light">
    <div class="container">
        <h2 class="jumbotron-heading">Marki</h2>
        <div class="row" >
            <c:forEach items="${brands}" var="brand">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <a href="#">
                        <img class="card-img-top" src="${brand.image}">
                        <%--<p class="card-text">${brand.name}</p>--%>
                    </a>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>


</body>
</html>