<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Lista de Produtos</legend>
	</fieldset>
	<table border="1">
	<thead>
		<th>ID</th>
		<th>Nome</th>
		<th>Descricao</th>
		<th>Preco</th>
		<th>acoes</th>
	</thead>
	<c:forEach var="produto" items="${produtoList}">
		<tr>
			<td>${produto.id}</td>
			<td>${produto.nome}</td>
			<td>${produto.descricao}</td>
			<td>${produto.preco}</td>
			<td align="center">
				<a href="edita?id=${produto.id}">
					<img alt="Editar produto" src="../imagens/ico.editar.gif">
				</a>
				<a href="remove?id=${produto.id}">
					<img alt="Editar produto" src="../imagens/ico.excluir.gif">
				</a>
			</td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>