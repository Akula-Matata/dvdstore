<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>

<z:layout>
    <br>
    <div class="row">
        <div class="col-md-6 ml-auto mr-auto">
            <h1 class="display-4">Вход в систему</h1>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-6 ml-auto mr-auto">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="username">Имя: </label>
                    <input type="text" id="username" name="username" placeholder="Имя пользователя" class="form-control"/> <br/>
                    <label for="password">Пароль: </label>
                    <input type="password" id="password" name="password" placeholder="Пароль" class="form-control"/> <br/>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
            </form>
        </div>
    </div>
</z:layout>