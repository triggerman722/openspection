<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="container">
	<form:form method="POST" modelAttribute="applicationForm" class="form-signin">
        <h2 class="form-signin-heading">Create your application</h2>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
</div>
<c:import url="/postbase.jsp" />
