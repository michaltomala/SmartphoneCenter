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

</head>
<body>

<%@include file="header.jsp"%>

<main role="main">

    <section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">SmartphoneCenter</h1>
            <p class="lead text-muted">Witaj na stronie internetowej poświęconej technologii smartphonowej.</p>
            <p class="lead text-muted">
            Znajdziesz tutaj aktualne informacje o wszystkich smartphonach jak i artykuły im poświęcone
            <p>
                <a href="/login" class="btn btn-primary my-2">Zaloguj się</a>
                <a href="/register" class="btn btn-secondary my-2">Zarejestruj się</a>
            </p>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <h2 class="jumbotron-heading">Artykuły</h2>
            <div class="row" id="articles" >
            </div>
            <div class="row" >
                <h2 class="jumbotron-heading" >#W skrócie</h2>
                <div class="list-group" id="InShort">
                </div>
            </div>
        </div>
    </div>

</main>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Wróć do góry </a>
        </p>
    </div>
</footer>


<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="../js/articles.js"></script>

</body>
</html>
