<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/9/1
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
  <style>
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
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .container h2 {
      text-align: center;
    }

    .container .form-group {
      margin-bottom: 20px;
    }

    .container .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .container .form-group input[type="text"],
    .container .form-group input[type="password"] {
      width: 100%;
      padding: 10px;
      font-size: 16px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }

    .container .form-group input[type="checkbox"] {
      margin-left: 10px;
    }

    .container .form-group input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #555;
      color: #fff;
      font-weight: bold;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
  <script>
    window.onload=function () {
      document.getElementById("img").onclick=function () {
        this.src="${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
      }
    }
  </script>
</head>
<body>
<div class="container">
  <h2>管理员登录</h2>
  <form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <div class="form-group">
      <label for="username">用户名:</label>
      <input type="text" id="username" name="username" required>
    </div>
    <div class="form-group">
      <label for="password">密码:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <div class="form-group">
      <label for="captcha">验证码:</label>
      <input type="text" id="captcha" name="captcha" required>
      <img id="img" src="${pageContext.request.contextPath}/checkCodeServlet" alt="Captcha Image">
      <p>点击图片重新加载</p>
    </div>
    <div class="form-group">
      <input type="submit" value="登录">
      <a href="register.jsp" >注册 </a>
    </div>
  </form>
  <div>
    ${cc_error}
  </div>
  <div>
    ${login_error}
  </div>
  <div>
    ${succeed}
  </div>
</div>
</body>
</html>