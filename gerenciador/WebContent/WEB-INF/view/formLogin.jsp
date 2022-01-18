<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:url value="/entrada" var="linkEntradaServlet"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="${ linkEntradaServlet}" method="post">
		
		<label for="login">Login:</label>
		<input type="text" name="login"> </br>
		
		<label for="senha">Senha:</label>
		<input type="password" name="senha">
		
		<input type="hidden" name="acao" value="Login">
		
		<input type="submit">
		
	</form>

</body>
</html>