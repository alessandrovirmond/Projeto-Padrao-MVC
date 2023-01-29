<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login </title>
</head>
<body>

<form action="/riocard/Control" method="post">
Login: <input type="text" name="login"> <br>
Senha: <input type="password" name="senha"> <br>
<input type="hidden" name="acao" value="UsuarioLogar">
<input type="hidden" name="nextPage" value="/form/index2.jsp">
<input type="submit" value="Enviar"> ${msg}
</form>

<a href="registro.html">Registrar-se </a>

</body>
</html>