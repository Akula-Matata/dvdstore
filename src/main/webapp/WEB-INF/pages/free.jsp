<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout>

    <br>
    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <h1 class="display-4">Свободные диски: </h1>
        </div>
    </div>
    <br>

    <div class="row">
        <div class="col-md-8 ml-auto mr-auto">
            <form action="/free" method="post">
                <c:forEach items="${notTakenItems}" var="disk">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="card bg-light">
                                <div class="card-body">
                                    <div class="row">

                                        <div class="col-sm-8 align-self-center">
                                            <h4>#${disk.getId()}. ${disk.getCapture()}</h4>
                                            <p><strong>Владелец: </strong>${disk.getUser().getUsername()}</p>
                                        </div>
                                        <div class="col-sm-4 align-self-center">
                                            <button type="submit" class="btn btn-primary btn-block" name="diskId"
                                                    value="${disk.getId()}">Взять
                                            </button>
                                        </div>

                                            <%--<p class="card-text"><strong>Владелец: </strong>${disk.getUsername()}</p>--%>
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