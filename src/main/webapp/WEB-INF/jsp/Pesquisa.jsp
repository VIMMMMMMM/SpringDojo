<%--
  Created by IntelliJ IDEA.
  User: Pichau
  Date: 5/21/2024
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pesquisar</title>
</head>
<body>


<form name="form1" method="get" action="/pesquisar">
    <table>
        <tr>
            <td>Digite os dados do livro</td>
        </tr>

        <tr>
            <td>Título</td>
            <td><input type="text" name="titulo"></td>
        </tr>
        <tr>
            <td><button type="submit" >Enviar</button></td>
            <td><input type="reset" value="Limpar"></td>
        </tr>

    </table>
    <table>
        <tr>
            <td>
            <td><font color="red" size="14"><%= request.getSession().getAttribute("livros")!= null ?request.getSession().getAttribute("livros"):""  %></font>
            </td>
        </tr>

    </table>
</form>


</body>
</html>
