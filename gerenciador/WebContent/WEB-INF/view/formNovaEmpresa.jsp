<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:url value="/entrada?acao=NovaEmpresa" var="linkEntradaServlet"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form action="${ linkEntradaServlet}" method="post">
		
		<label for="nome">Nome:</label>
		<input type="text" name="nome">
		
		<label for="data">Data de abertura:</label>
		<input type="text" name="data">
		
		<input type="submit">
		
	</form>

</body>
</html>