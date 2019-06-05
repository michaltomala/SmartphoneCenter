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
    <link rel="stylesheet" href="/css/style.css" />

</head>
<body class="dashboard">

<%@include file="../header.jsp"%>

<div class="table-wrapper">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-6"><h2><b>${brand.name}</b></h2></div>
            <div class="col-sm-6">
                <div class="btn-group" data-toggle="buttons">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/admin/dashboard" role="button">Panel Administratora</a>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-striped table-hover">
        <thead >
            <tr id="head section">
            <th>#</th>
            <th>Nazwa</th>
            <th>Cena</th>
            <th>
            <a href="/admin/phone/create/firstStep" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Dodaj</span></a>
            </th>
            <th>Edycja</th>
            <th><a href="/admin/phone/delete/" class="btn btn-danger" id="deleteLink"><i class="material-icons"></i> <span>Usuń</span></a>
            </th>
            </tr>
        </thead>
        <tbody id="phones section">
        </tbody>
    </table>
</div>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="/js/singleBrand.js"></script>
</body>
</html>