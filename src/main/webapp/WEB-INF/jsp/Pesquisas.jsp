<%--
  Created by IntelliJ IDEA.
  User: Pichau
  Date: 5/21/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>todos os livros</title>
</head>
<body>

<form name="form2" method="get" action="/pesquiso">
    <table>
        <tr>
            <td><font color="red" size="14"><%= request.getSession().getAttribute("livros")!= null ?request.getSession().getAttribute("livros"):""  %></font>
        </tr>
    </table>
</form>
<% request.getSession().removeAttribute("livros"); %>
</body>
</html>
