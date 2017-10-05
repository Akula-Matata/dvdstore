<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout>
    <br>
    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <h1 class="display-4">Взятые мной диски: </h1>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <form action="/taken" method="post">
                <c:forEach items="${takenByUserItems}" var="item">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card bg-light">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-8 align-self-center">
                                            <h4>#${item.getDisk().getId()}. ${item.getDisk().getCapture()}</h4>
                                            <p><strong>Владелец: </strong>${item.getDisk().getUser().getUsername()}</p>
                                        </div>
                                        <div class="col-sm-4 align-self-center">
                                            <button type="submit" class="btn btn-danger btn-block" name="itemId"
                                                    value="${item.getId()}">Отдать
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </form>
        </div>
    </div>
    </div>
</z:layout>