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
    <link rel="stylesheet" href="../../css/style.css" />

</head>
<body class="dashboard">

<%@include file="../header.jsp"%>

    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6"><h2><b>Panel administracyjny</b></h2></div>
                <div class="col-sm-6">
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-info active">
                            <input type="radio" name="status" value="all" checked="checked"> Marki
                        </label>
                        <label class="btn btn-info active" >
                            <input type="radio" name="status" value="active" > Smartphony
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Domain</th>
                <th>Created&nbsp;On</th>
                <th>Status</th>
                <th>Server&nbsp;Location</th>
                <th>
                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> <span>Dodaj</span></a>
                </th>
                <th>Edycja</th>
                <th><a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons"></i> <span>Usuń</span></a>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr data-status="active">
                <td>1</td>
                <td><a href="#">loremvallis.com</a></td>
                <td>04/10/2013</td>
                <td><span class="label label-success">Active</span></td>
                <td>Buenos Aires</td>
                <td></td>
                <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
                <td>
                    <input type="checkbox" name="options[]" value="1">
                </td>
            </tr>
            <tr data-status="inactive">
                <td>2</td>
                <td><a href="#">quisquamut.net</a></td>
                <td>05/08/2014</td>
                <td><span class="label label-warning">Inactive</span></td>
                <td>Australia</td>
                <td></td>
                <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
                <td>
                    <input type="checkbox" name="options[]" value="2">
                </td>
            </tr>
            <tr data-status="active">
                <td>3</td>
                <td><a href="#">convallissed.com</a></td>
                <td>11/05/2015</td>
                <td><span class="label label-success">Active</span></td>
                <td>United Kingdom</td>
                <td></td>
                <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
                <td>
                    <input type="checkbox" name="options[]" value="3">
                </td>
            </tr>
            <tr data-status="expired">
                <td>4</td>
                <td><a href="#">phasellusri.org</a></td>
                <td>06/09/2016</td>
                <td><span class="label label-danger">Expired</span></td>
                <td>Romania</td>
                <td></td>
                <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
                <td>
                    <input type="checkbox" name="options[]" value="4">
                </td>
            </tr>
            <tr data-status="inactive">
                <td>5</td>
                <td><a href="#">facilisleo.com</a></td>
                <td>12/08/2017</td>
                <td><span class="label label-warning">Inactive</span></td>
                <td>Germany</td>
                <td></td>
                <td><a href="#" class="btn btn-sm manage">Edytuj</a></td>
                <td>
                    <input type="checkbox" name="options[]" value="5">
                </td>
            </tr>
            </tbody>
        </table>
    </div>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="../../js/dashboard.js"></script>
</body>
</html>