<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout>

    <br>
    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <div class="alert ${type}" role="alert">
                <h3 class="alert-heading">${topic}</h3>
                <p class="lead">${message}</p>
                <hr>
                <p class="mb-0"><small>Можете продолжить работу с системой.</small></p>
            </div>
        </div>
    </div>
    <br>

</z:layout>