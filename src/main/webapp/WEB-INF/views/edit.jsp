<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> -->
<!-- <script src="http://code.jquery.com/jquery-1.9.1.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->

<portlet:actionURL var="saveURL">
	<portlet:param name="action" value="addProject" />
</portlet:actionURL>

<form:form action="${saveURL}" method="post" modelAttribute="project"
	commandName="project">

	<div>
		Title:
		<form:input path="title" />
	</div>
	<div>
		Members:
		<form:input path="members" />
	</div>
	<div>
		External: <br>
		<form:radiobutton path="external" value="true" />
		true<br>
		<form:radiobutton path="external" value="false" />
		false<br>
	</div>
	<div>
		Delivery Date:
		<form:input path="deliveryDate" />
	</div>
	<div>
		Technologies:
		<form:input path="technologies" />
	</div>

	<div>
		<input type="submit" value="send" />
	</div>
</form:form>