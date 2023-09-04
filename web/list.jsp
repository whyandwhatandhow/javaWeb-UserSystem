<%@ page import="crud.domain.User" %>
<%@ page import="crud.web.servlet.UserListServlet"%>
<%@ page import="crud.service.UserService" %>
<%@ page import="crud.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dd
  Date: 2023/8/31
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
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
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .action-buttons {
            display: flex;
            gap: 10px;
        }

        .add-button {
            margin-top: 10px;
            padding: 8px 16px;
            background-color: #555;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
    <script>
        function deleteUser(id) {
            if(confirm("确定删除吗"))
            location.href="${pageContext.request.contextPath}/deleteServlet?id="+id;

        }
    </script>
</head>
<body>
<div class="container">
    <h1>员工表</h1>
    <table>
        <thead>
        <tr>
            <th><input type="checkbox"></th>
            <th>Id</th>
            <th>Name</th>
            <th>Sex</th>
            <th>Identy</th>
            <th>Title</th>
            <th>Password</th>
            <th>Choose</th>
        </tr>
        </thead>
        <tbody>
        <!-- Example rows (replace with dynamic data) -->
        <tr  style="color: red">
            <td>0</td>
            <td>000</td>
            <td>John Doe</td>
            <td>Male</td>
            <td>1234567890</td>
            <td>Developer</td>
            <td>******</td>
            <td colspan="2">示例</td>
        </tr>
        <%
            UserService service=new UserServiceImpl();
            List<User> users=service.findAll();
            for (User user  : users) {


        %>
        <tr>
            <th><input type="checkbox"></th>
            <td><%= user.getId() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getSex() %></td>
            <td><%= user.getIdenty() %></td>
            <td><%= user.getTitle() %></td>
            <td><%= user.getPassword() %></td>
            <td class="action-buttons">
                <a href="${pageContext.request.contextPath}/updateUserServlet?userId=<%=user.getId()%>">update</a>
                <a href="javascript:deleteUser(<%=user.getId()%>);">Delete</a>
        </tr>

        <%
            }
        %>
        </tbody>

    </table>
<button style="margin-top: 50px">批量删除</button>
</div>
</body>
</html>

