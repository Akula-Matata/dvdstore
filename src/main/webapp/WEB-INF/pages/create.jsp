<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<z:layout>
    <br>
    <div class="row">
        <div class="col-md-6 ml-auto mr-auto">
            <h1 class="display-4">Создать свой диск: </h1>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-6 ml-auto mr-auto">
            <form action="/create" method="post">
                <div class="form-group">
                    <label for="capture">Название: </label>
                    <input type="text" class="form-control" id="capture" name="capture"
                           placeholder="Введите название диска">
                    <small class="form-text text-muted">До 50 символов</small>
                </div>
                <button type="submit" class="btn btn-success btn-block">Создать</button>
            </form>
        </div>
    </div>
</z:layout>