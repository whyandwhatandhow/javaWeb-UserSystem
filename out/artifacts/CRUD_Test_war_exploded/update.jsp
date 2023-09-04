<%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/9/2
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改信息</title>
    <style>
        a {
            display: block;
            text-align: center;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border-radius: 5px;
            text-decoration: none; /* Remove the underline */
        }

        a:hover {
            background-color: #0056b3; /* Maintain the background color on hover */
            color: #fff; /* Maintain the text color on hover */
        }
        /* 添加样式以美化页面 */
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], input[type="password"] {
            width: 380px;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 185px;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>修改信息</h2>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <input type="hidden" id="id" name="id" value="${param.userId}" >
        <label for="姓名">姓名：</label>
        <input type="text" id="姓名" name="name" required>

        <label>性别：</label>
        <select name="Sex" required>
            <option value="男">男</option>
            <option value="女">女</option>
        </select>

        <label for="身份证">身份证：</label>
        <input type="text" id="身份证" name="identy" required>

        <label for="职位">职位：</label>
        <input type="text" id="职位" name="title" required>

        <label for="密码">密码：</label>
        <input type="password" id="密码" name="password" required>

        <input type="submit" value="修改">
        <a href="list.jsp">返回</a>
    </form>

</div>
</body>
</html>
