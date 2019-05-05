<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">

            <a class="py-2 d-none d-md-inline-block" href="#" style="text-decoration: none;">Marki</a>
            <a class="py-2 d-none d-md-inline-block" href="#">Wszystkie Smartphony</a>
            <a class="py-2 d-none d-md-inline-block" href="#">Artykuły</a>
            <a class="py-2 d-none d-md-inline-block" href="#">Flagowce</a>
            <a class="py-2 d-none d-md-inline-block" href="#">ExFlagowce</a>

            <a href="#" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2"><path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path><circle cx="12" cy="13" r="4"></circle></svg>
                <strong>SmartphoneCenter</strong>
            </a>
            <c:if test="${empty user}">
                <a class="py-2 d-none d-md-inline-block" href="#">Zaloguj</a>
                <a class="py-2 d-none d-md-inline-block" href="#">Zarejestruj</a>
            </c:if>
            <c:if test="${not empty user}">
                <a class="py-2 d-none d-md-inline-block" href="#">${user.name}</a>
            </c:if>
        </div>
    </div>
</header>