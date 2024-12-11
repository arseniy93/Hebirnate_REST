<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 09.11.2024
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Создание задачи</title>
</head>
<body>
<h1>Создание задачи</h1>

<form action="${pageContext.request.contextPath}/user/tasks/" method="post">
  <label for="title">Заголовок:</label><br>
  <input type="text" id="title" name="title"><br>

  <label for="description">Описание:</label><br>
  <textarea id="description" name="description"></textarea><br>
  <button type="submit">Создать</button>

</form>
</body>
</html>
