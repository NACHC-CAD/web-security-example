<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="home" value="${pageContext.request.contextPath}" scope="request"/>

<script>
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function () {
	    window.history.pushState(null, "", window.location.href);
	};	
</script>