<%@ taglib tagdir="/WEB-INF/tags" prefix="custom"%>

<%@ include file="/WEB-INF/views/init.jsp"%>

<custom:sample-layout>
	<jsp:body>

		<div class="container">
		
			<h2>
				<spring:message code="label.search-shop" />
			</h2>
		
			<c:if test="${not empty successDeleteShop}">
				<div class="alert alert-success"><spring:message code="success.delete-shop" /></div>
			</c:if>
			
			<portlet:renderURL var="searchURL">
				<portlet:param name="entity" value="shopEntity" />
				<portlet:param name="action" value="searchShops" />
			</portlet:renderURL>
			
<%-- 			<portlet:resourceURL var="searchShopAjaxURL" id="searchShopAjax" /> --%>
			<portlet:resourceURL var="searchShopAjaxURL" id="searchShopAjax"  >
				<portlet:param name="entity" value="shopEntity" />
			</portlet:resourceURL>
			
			<portlet:renderURL var="addURL">
				<portlet:param name="entity" value="shopEntity" />
		        <portlet:param name="action" value="newShop" />
		    </portlet:renderURL>
			
	
			<form:form action="${searchURL}" method="post" commandName="shopCriteriaSearchForm" name="shopCriteriaSearchForm" class="form-horizontal">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-6 row">
							<div class="col-lg-4 col-md-4">
								<form:label path="name">
									<spring:message code="label.shop.name" />
								</form:label>
							</div>
							<div class="col-lg-8 col-md-8">
								<form:input path="name" cssClass="form-control" />
							</div>
						</div>
						<div class="col-lg-6 col-md-6 row">
							<div class="col-lg-4 col-md-4">
								<form:label path="name">
									<spring:message code="label.shop.billing" />
								</form:label>
							</div>
							<div class="col-lg-8 col-md-8">
								<form:input path="billing" cssClass="form-control" />
							</div>
						</div>
					</div>
				</div>
				
				<hr />
				
			</form:form>
			
			<div class="form-group media row">
				<div class="col-md-12 col-lg-12">
					<button class="btn btn-danger" onclick="javascript:searchAjax();">
						<span class="glyphicon glyphicon-search"></span> 
						<spring:message code="button.search-ajax" />
					</button>
					<button id="clean" type="button" class="btn btn-default">
						<span class="glyphicon"></span> 
						<spring:message code="button.clean" />
					</button>
				</div>
			</div>
			
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
			    <a class="accordion-toggle" data-toggle="collapse" data-target="#shops" href="#shops">
			    	<spring:message code="label.shop.shop-list" />
				</a>
			</div>
			
			<div class="media">
				<div class="col-lg-12 col-md-12">	
					<button class="btn btn-success submit pull-right" onclick="window.location.href='${addURL}'">
						<span class="glyphicon glyphicon-plus"></span>
						<spring:message code="button.new" />
					</button>
				</div>
			</div>
			
			<div class="panel-body panel-collapse collapse in" id="shops">
				<jsp:include page="shop-search-results.jsp" />
			</div>
		</div>
		
		<script type="text/javascript">
		
			function searchAjax(){
				function callbackSearchAjax(data){
					$("#shops").html(data);
				}
				$.get("${searchShopAjaxURL}", $('#shopCriteriaSearchForm').serialize(), callbackSearchAjax);
				return false;
			}
			
			$(document).ready(function(){
				$('#clean').on('click', function(){
					cleanForm();
				});
			});
			
			function cleanForm(){ 
				$('#name').val('');
				$('#billing').val('');
			}
			
		</script>
		
		
	</jsp:body>
</custom:sample-layout>