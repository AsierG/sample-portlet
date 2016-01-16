<%@ taglib tagdir="/WEB-INF/tags" prefix="custom"%>

<%@ include file="/WEB-INF/views/init.jsp" %>

<custom:sample-layout>
	<jsp:body>
	
		<portlet:actionURL var="saveURL">
			<portlet:param name="entity" value="shopEntity" />
			<portlet:param name="action" value="saveShop" />
		</portlet:actionURL>
		
		<form:form action="${saveURL}" modelAttribute="shop" method="post" commandName="shop" name="shop" id="shopForm">
		
			<form:hidden path="shopId" />
			<form:hidden path="modifiedDate" name="modifiedDate" id="modifiedDate" />
			
			<!-- ERRORS MESSAGES -->
			<c:if test="${not empty concurrencyError}">
				<div class="alert alert-danger"><spring:message code="error.concurrency-error" /></div>
			</c:if>
			
			<c:if test="${not empty errors}">
				<div class="alert alert-danger"><spring:message code="label.foo.errors" /></div>
			</c:if>
			
			<c:if test="${not empty successSave}">
				<div class="alert alert-success"><spring:message code="success.save-shop" /></div>
			</c:if>
			<c:if test="${not empty successUpdate}">
				<div class="alert alert-success"><spring:message code="success.update-shop" /></div>
			</c:if>
			
			
			
			<div class="form-group">
				<div class="col-lg-12 col-md-12"><form:errors path="name" element="div" cssClass="alert alert-danger" /></div>
				<div class="col-lg-1 col-md-1">
					<form:label path="name">
						<spring:message code="label.shop.name" />
					</form:label>
				</div>
				<div class="col-lg-11 col-md-11">
					<form:input path="name" cssClass="form-control" name="name" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-12 col-md-12"><form:errors path="billing" element="div" cssClass="alert alert-danger" /></div>
				<div class="col-lg-1 col-md-1">
					<form:label path="billing">
						<spring:message code="label.shop.billing" />
					</form:label>
				</div>
				<div class="col-lg-11 col-md-11">
					<form:input path="billing" cssClass="form-control" name="billing" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-12 col-md-12"><form:errors path="workers" element="div" cssClass="alert alert-danger" /></div>
				<div class="col-lg-1 col-md-1">
					<form:label path="workers">
						<spring:message code="label.shop.workers" />
					</form:label>
				</div>
				<div class="col-lg-11 col-md-11">
					<form:input path="workers" cssClass="form-control" name="workers" />
				</div>
			</div>
			
			
			<hr />
		
			<!-- BUTTONS -->
			
			<div class="col-lg-12 col-md-12 media">
				
				<button type="button" id="update" class="btn btn-warning pull-left" onclick="submitForm(this.form.id,this.form.action);">
					<span class="glyphicon glyphicon-pencil"></span> 
					<c:choose>
						<c:when test="${shop.shopId !=0}">
							<spring:message code="button.update" />
						</c:when>
						<c:otherwise>
							<spring:message code="button.save" />
						</c:otherwise>
					</c:choose>
			        
			    </button>
				
				<%-- Return button --%>
			    <portlet:renderURL var="returnURL" />
			    <button id="return" type="button" class="btn btn-default" onclick="window.document.location='${returnURL}'">	       
			    	<span class="glyphicon glyphicon-arrow-left"></span>
			    	<spring:message code="button.return" />	
			    </button>
			  
			</div>
			
			<!------------->
			
		</form:form>
									
	</jsp:body>
</custom:sample-layout>

		
<script>

function submitForm(formId, action){
	formToSend = document.getElementById(formId);
	formToSend.action = action;
	formToSend.submit();
}


</script>