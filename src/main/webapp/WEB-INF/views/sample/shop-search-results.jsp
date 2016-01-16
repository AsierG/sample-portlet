<%@ include file="/WEB-INF/views/init.jsp" %>

<div class="col-md-12 col-lg-12">
	<table class="table table-hover">
		<tr>
			<th><spring:message code="label.shop.name" /></th>
			<th><spring:message code="label.shop.billing" /></th>
			<th><spring:message code="label.shop.workers" /></th>
		</tr>
		<c:forEach items="${results}" var="result">
			<portlet:renderURL var="detailURL">
				<portlet:param name="entity" value="shopEntity" />
				<portlet:param name="action" value="editShop" />
				<portlet:param name="fromList" value="true" />
				<portlet:param name="shopId"	value="${result.shopId}" />
			</portlet:renderURL>
			<tr onclick="window.document.location='${detailURL}';">
				<td>${result.name}</td>
				<td>${result.billing}</td>
				<td>${result.workers}</td>
			</tr>
		</c:forEach>
	</table>
</div>