<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">DVD сервис</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/about">О проекте</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <c:choose>
                <c:when test="${!auth.getPrincipal().toString().equals('anonymousUser')}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">${authUser.getUsername()} </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <a class="dropdown-item" href="/free">Свободные диски</a>
                            <a class="dropdown-item" href="/create">Создать свой диск</a>
                            <a class="dropdown-item" href="/taken">Взятые мной диски</a>
                            <a class="dropdown-item" href="/given">Взятые у меня диски</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/logout">Выйти</a>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Войти</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>