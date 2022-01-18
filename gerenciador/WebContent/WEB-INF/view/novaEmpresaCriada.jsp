<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<html>
	<body>
	
		<c:if test="${ not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso! 
		Data de abertura: <fmt:formatDate value="${data }" pattern="dd/MM/yyyy" />
		</c:if>
		
		<c:if test="${ empty empresa}">
			Nenhuma empresa cadastrada
		</c:if>
		
	</body>
</html>