<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />

<div class="container-fluid">
	<div class="container">
		<div class="media">
			<img class="mr-3 rounded-circle" src="/resources/img/back0.jpg" alt="Generic placeholder image" width="48" height="48">
			<div class="media-body">
			</div>
		</div>
		<div>
			<h5>This is the id: ${inspection.getId()}</h5>
		</div>
	</div>
</div>
<c:import url="/postbase.jsp" />
