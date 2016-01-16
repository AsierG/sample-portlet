<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="names" value="${fn:split(requestScope.tabNames, ',')}" />
<c:set var="values" value="${fn:split(requestScope.tabValues, ',')}" />
<c:set var="entity" value="${requestScope.entity}" />
<c:set var="tab" value="${requestScope.tab}" />
<c:set var="action" value="${requestScope.action}" />

<c:if test="${empty entity and not empty values}">
    <c:set var="entity" value="${values[0]}" />
</c:if>

<ul class="nav nav-tabs">
	<c:forEach begin="0" end="${fn:length(names) - 1}" varStatus="i">	
	    <c:if test="${not empty values[i.index]}">    
			<portlet:renderURL var="navURL">
				<c:choose>
					<c:when test="${not empty tab}">
						<portlet:param name="entity" value="${entity}" />
						<portlet:param name="tab" value="${values[i.index]}" />
					</c:when>
					<c:otherwise>
						<portlet:param name="entity" value="${values[i.index]}" />
					</c:otherwise>
				</c:choose>
				<c:if test="${not empty action}">
					<portlet:param name="action" value="${action}" />
				</c:if>
			</portlet:renderURL>
			<li data-attr="${tab} - ${entity} - ${action} - ${id}" 
				<c:if test="${(empty tab && empty action && entity == values[i.index]) || tab == values[i.index]}">
  				 	class="active"
  				</c:if>
  			>
				<a href="${navURL}">
				     <spring:message code="tab.${names[i.index]}" />
				</a>
		    </li>
	    </c:if>
	</c:forEach>
</ul>