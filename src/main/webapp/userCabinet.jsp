<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ru">
<%--<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>--%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Management Board</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user_cabinet.css">


</head>
<body>
<h1>Твои задачи</h1>


<table class="table table-bordered custom-table">
    <thead>
    <tr>
        <th>НЕ НАЧАТО</th>
        <th>В ПРОГРЕССЕ</th>
        <th>ВЫПОЛНЕНО</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <c:forEach items="${tasks}" var="task">
                <c:if test="${task.tasksList == 'НЕ НАЧАТО'}">
                    <h5>${task.title}</h5>
                </c:if>
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${tasks}" var="task">
                <c:if test="${task.tasksList == 'В ПРОГРЕССЕ'}">
                    <h5>${task.title}</h5>
                </c:if>
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${tasks}" var="task">
                <c:if test="${task.tasksList == 'ВЫПОЛНЕНО'}">
                    <h5>${task.title}</h5>
                </c:if>
            </c:forEach>
        </td>
    </tr>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>


