<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="home" value="${pageContext.request.contextPath}" scope="request"/>

<html>
	<table width="100%">
		<tr>
			<td align="left">
				<a href="${home}/app/index.jsp">Index</a>
			</td>
			<td align="right">
				<a href="">Log Off</a>
			</td>
		</tr>
	</table>
</html>