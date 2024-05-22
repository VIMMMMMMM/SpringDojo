<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro - Com campos preenchidos</title>

</head>
<body>
<h2>Detalhes do Livro</h2>
<form name="form1" method="get" action="/alterar/<%= livro.getTitulo() %>" >
<table>
	<tr>
		<td><font color="red" size="14"><%= request.getSession().getAttribute("mensagem")!= null ?request.getSession().getAttribute("mensagem"):""  %></font>
	</tr>
	<tr>
		<td>Digite os dados do livro</td>
	</tr>

	<tr>
		<td>Título</td>
		<td><input type="text" name="titulo"><%= livro.getTitulo() %></td>
	</tr>

	<tr>
		<td>Editora</td>
		<td><input type="text" name="editora"><%= livro.getEditora() %></td>
	</tr>
	<tr>
		<td><button type="submit" >Alterar</button></td>
		<td><button type="submit">Remover</button></td>
	</tr>

</table>
</form>
</body>
</html>


