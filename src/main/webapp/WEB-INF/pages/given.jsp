<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout>

    <br>
    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <h1 class="display-4">Взятые у меня диски: </h1>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <c:forEach items="${givenByUserItems}" var="item">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card bg-light">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-8 align-self-center">
                                        <h4>#${item.getDisk().getId()}. ${item.getDisk().getCapture()}</h4>
                                        <p><strong>Диск у: </strong>${item.getUser().getUsername()}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
            </c:forEach>
        </div>
    </div>
    </div>
</z:layout>