<%@tag description="Sample Layout" pageEncoding="UTF-8"%>

<%@ attribute name="header" fragment="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="bootstrapit" class="tab-content">

	<div id="header">
		<jsp:invoke fragment="header" />
	</div>
	
	<c:set var="tabNames" value="" />
    <c:set var="tabValues" value="" />
    
	<c:set var="tabNames" value="shopEntity," />
	<c:set var="tabValues" value="shopEntity," />
    <c:if test="${hasAccessBarPermission}">
	    <c:set var="tabNames" value="${tabNames}barEntity," />
	    <c:set var="tabValues" value="${tabValues}barEntity," />
    </c:if>
	<c:set var="tabNames" value="${tabNames}" scope="request" />
	<c:set var="tabValues" value="${tabValues}"	scope="request" />
	
	<c:if test="${empty entity or entity eq 'centerSheet'}">
        <c:set var="entity" value="shopEntity" />
    </c:if>
    
	<c:set var="tabNames" value="${tabNames}" scope="request" />
	<c:set var="tabValues" value="${tabValues}"	scope="request" />
	<c:set var="entity" value="${entity}" scope="request" />
	
	<jsp:include page="../components/tabs.jsp" flush="true" />
	
	<div class="tab-content">
		<div class="tab-pane active">
			<jsp:doBody />
		</div>
	</div>
</div>