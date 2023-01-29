<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Post </title>
</head>
<body>
Seja bem-vindo: ${usuario.nome}
<br>
<br>
<form action="/riocard/Control" method="get">
Nome <input type="text" name="nome" value="${estudante.nome}"> <br>
Matricula <input type="text" name="matricula" value="${estudante.matricula}"> <br>
<input type="hidden" name="id" value="${estudante.id}">

<input type="hidden" name="acao" value="EstudanteAlterar">
<input type="hidden" name="nextPage" value="/form/msg.jsp">
<input type="submit">
</form>




