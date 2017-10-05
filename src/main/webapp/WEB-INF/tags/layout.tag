<%@ tag body-content="scriptless" %>

<!DOCTYPE html>
<html lang="ru">
    <jsp:include page="../partials/_head.jsp"/>
    <body>
        <jsp:include page="../partials/_nav.jsp"/>
        <div class="container">
            <jsp:doBody/>
        </div>
        <jsp:include page="../partials/_scripts.jsp"/>
    </body>
</html>