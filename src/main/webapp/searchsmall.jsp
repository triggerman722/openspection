<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<div class="container">
		<form:form method="POST" modelAttribute="searchrequest" class="form-signin">
			<div class="form-row">
				<div class="col-md-5">
					<form:input type="text" path="keywords" class="form-control col-md-12 mr-2" placeholder="keywords" autofocus="true"></form:input>
				</div>
				<div class="col-md-5">
					<form:input type="text" path="location" class="form-control col-md-12 mr-2" placeholder="location" autofocus="true"></form:input>
				</div>
				<div class="col-md-2">
					<button class="btn btn-success col-md-12" type="submit"><i class="fa fa-search"></i></button>
				</div>
			</div>
	</div>
</div>
