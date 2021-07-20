<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="home" value="${pageContext.request.contextPath}" scope="request"/>

<head>

	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="-1" />
	<meta http-equiv="CACHE-CONTROL" content="NO-CACHE" />

	<script>
		if(performance.navigation.type == 2){
			console.log("Doing reload");   
			location.reload(true);
			console.log("Done with reload");
		}
		console.log("Script loaded.")
	</script>
	
</head>
