<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/8/30
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>$Title$</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f2f2f2;
    }

    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
    }

    h1 {
      text-align: center;
      color: #333;
    }

    a {
      display: block;
      text-align: center;
      margin: 20px auto;
      padding: 10px 20px;
      background-color: #555;
      color: #fff;
      border-radius: 5px;
      text-decoration: none; /* Remove the underline */
    }

    a:hover {
      background-color: #555; /* Maintain the background color on hover */
      color: #fff; /* Maintain the text color on hover */
    }

    /* Center the container */
    .center-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
  </style>
</head>
<body>
<div class="center-container"> <!-- Added a new container class -->
  <div class="container">
    <a href="${pageContext.request.contextPath}/userListServlet">查询所有用户信息</a>
  </div>
</div>
</body>
</html>

