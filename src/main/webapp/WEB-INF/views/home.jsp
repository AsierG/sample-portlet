<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<portlet:renderURL var="addURL">
	<portlet:param name="action" value="addProject" />
</portlet:renderURL>

<a href="${addURL}">Add Project</a>

<h3>New Project Portlet</h3>

<table border="1">
	<tr>
		<td>Title</td>
		<td>Members</td>
		<td>DeliveryDate</td>
		<td>Technologies</td>
	</tr>
	<c:forEach items="${projects}" var="project">
		<tr>
			<td>${project.title}</td>
			<td>${project.members}</td>
			<td>${project.deliveryDate}</td>
			<td>${project.technologies}</td>
		</tr>
	</c:forEach>
</table>


