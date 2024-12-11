<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 05.10.2024
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">

    <h2>User Register Form
        <br>${id}</br></h2>
    <div class="col-md-6 col-md-offset-3">
        <div class="alert alert-success center" role="alert">
            <p>${NOTIFICATION}</p>

        </div>

        <form action="<%=request.getContextPath()%>/register" method="post">

            <div class="form-group">
                <label for="uname">Имя:</label> <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="uname">Фамилия:</label> <input type="text" class="form-control" id="lastName" placeholder="last Name" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="uname">Почта:</label> <input type="text" class="form-control" id="email" placeholder="User Name" name="email" required>
            </div>

            <div class="form-group">
                <label for="uname">Пароль:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
