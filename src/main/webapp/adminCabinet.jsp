<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Management Board</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user_cabinet.css">
</head>
<body>
<h1>Твои задачи</h1>
<button id="createTaskButton">Создать задачу</button>

<table class="table table-bordered custom-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>ФИО</th>
        <th>Почта</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="loopStatus">
        <tr>
            <td>
                <h5>${user.id}</h5>
            </td>
            <td>
                <h5>${user.name} ${user.lastName}</h5>
            </td>
            <td>
                <h5>${user.email}</h5>
            </td>
            <td>

                <form action="<%=request.getContextPath()%>/admin" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" name="action" value="delete" class="btn btn-primary">Удалить</button>
                </form>
                <form action="<%=request.getContextPath()%>/admin" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" name="action" value="change" class="btn btn-primary">Изменить задачу</button>
                </form>
                <form action="<%=request.getContextPath()%>/admin" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <button type="submit" name="action" value="create" class="btn btn-primary">Создать задачу</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="script.js"></script>
</body>
</html>
<%--<!-- Модальное окно -->--%>
<%--<div id="taskModal" class="modal">--%>
<%--    <div class="modal-content">--%>
<%--        <span class="close">&times;</span>--%>
<%--        <h2>Задача</h2>--%>
<%--        <form id="taskForm">--%>
<%--            <input type="hidden" id="taskId" name="taskId">--%>
<%--            <div>--%>
<%--                <label for="title">Название:</label>--%>
<%--                <input type="text" id="title" name="title" required>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label for="description">Описание:</label>--%>
<%--                <textarea id="description" name="description" required></textarea>--%>
<%--            </div>--%>
<%--            <div>--%>
<%--                <label for="status">Статус:</label>--%>
<%--                <select id="status" name="status">--%>
<%--                    <option value="НЕ НАЧАТО">Не начато</option>--%>
<%--                    <option value="В ПРОГРЕССЕ">В прогрессе</option>--%>
<%--                    <option value="ВЫПОЛНЕНО">Выполнено</option>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <button type="submit">Сохранить</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>