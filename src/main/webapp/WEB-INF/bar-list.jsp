<%@ taglib tagdir="/WEB-INF/tags" prefix="custom"%>

<%@ include file="/WEB-INF/views/init.jsp"%>

<custom:guide-independent-layout>

	<jsp:body>

		<div class="container">
			<h2>
				<spring:message code="label.bar.bar-list" />
			</h2>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
			    <a class="accordion-toggle" data-toggle="collapse" data-target="#bars" href="#bars">
			    	<spring:message code="label.bar.bar-list" />
				</a>
			</div>
			
			<div class="panel-body panel-collapse collapse in" id="bars">
				<div class="container">
					<div class="row">
						<jsp:include page="bar-search-results.jsp" />
					</div>
				</div>
			</div>
		</div>

	</jsp:body>
</custom:guide-independent-layout>