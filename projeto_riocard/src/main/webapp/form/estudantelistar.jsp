<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar estudante</title>
</head>
<body>
<form action = "/riocard/Control" method="get">
Informe o nome do estudante <input type="text" name="texto">
<input type="hidden" name="acao" value="ServletEstudanteListar" > 
<input type="submit">


</form>

<c:forEach var="estudante" items="${estudantes}">
				<p> ${estudante.nome} - ${estudante.matricula}</p>
				<a href="/riocard/Control?acao=EstudanteRemover&id=${estudante.id}"> Excluir</a>
				<a href="/riocard/Control?acao=EstudanteTelaAlterar&id=${estudante.id}"> Alterar </a>
				
</c:forEach>

</body>
</html>