<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<form action="altera">
		<fieldset>
			<legend>Editar Produto</legend>
			
			<input type="hidden" name="produto.id" value="${produto.id}" /> 
			
			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="produto.nome" value="${produto.nome}" /> 
			
			<label for="descricao">Descricao:</label>
			<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
			
			<label for="preco">Preco:</label> 
			<input id="preco" type="text" name="produto.preco" value="${produto.preco}" />
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>

</body>
</html>