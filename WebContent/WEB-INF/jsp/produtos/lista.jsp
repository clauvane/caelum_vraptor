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
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Descricao</th>
		<th>Preco</th>
		<th>Comprar</th>
		<c:if test="${usuarioWeb.logado }">
			<th>Editar</th>
			<th>Remover</th>
		</c:if>
	</tr>
	</thead>
	<c:forEach var="produto" items="${produtoList}">
		<tr>
			<td>${produto.id}</td>
			<td>${produto.nome}</td>
			<td>${produto.descricao}</td>
			<td>${produto.preco}</td>
			<td>			
				<form action="<c:url value="/carrinho"/>" method="post">
					<input type="hidden" name="item.produto.id" value="${produto.id}"/>
					<input type="text" class="qtde" name="item.quantidade" value="1"/>
					<button type="submit">Comprar</button>
				</form>
			</td>
			<c:if test="${usuarioWeb.logado }">
				<td align="center">
					<a href="<c:url value="/produtos/${produto.id}"/>">Editar</a>
				</td>
				<td align="center">
					<form action="<c:url value="/produtos/${produto.id}" />" method="post">
						<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
				</td>
			</c:if>
		</tr>	
	</c:forEach>
</table>
</body>
</html>