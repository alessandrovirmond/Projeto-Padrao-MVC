<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Seja bem-vindo: ${usuario.nome} <a href="Control?acao=UsuarioSair"> Sair </a>
<br>
<br>

<a href="/riocard/form/formestudante.html" > - Incluir estudante</a> <br>
<a href="/riocard/form/estudantelistar.jsp" > - Listar estudante</a> <br>



</body>
</html>














