<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="alert alert-danger">
	<c:choose>
		<c:when test="${not empty errors}">
			<spring:message code="${errors}" />
		</c:when>
		<c:otherwise>
			<spring:message code="error.no-permissions" />
		</c:otherwise>
	</c:choose>
</div>