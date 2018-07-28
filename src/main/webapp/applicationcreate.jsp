<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="container">
	<form:form method="POST" modelAttribute="singlepost" class="form-signin">
        <h2 class="form-signin-heading">Create your application</h2>
        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Title"
                            autofocus="true"></form:input>
                <form:errors path="title"></form:errors>
            </div>
        </spring:bind>
            <div class="form-group">
                <form:input type="text" path="description" class="form-control" placeholder="description"></form:input>
            </div>
<div class="form-group">
<form:input type="date" path="dateexpired" class="form-control" placeholder="dateexpired"></form:input>
</div>
<div class="form-group">
<form:input type="number" step="any" path="latitude" class="form-control" placeholder="latitude"></form:input>
</div>
<div class="form-group">
<form:input type="number" step="any" path="longitude" class="form-control" placeholder="longitude"></form:input>
</div>
<div class="form-group">
<form:input type="number" path="radius" class="form-control" placeholder="radius"></form:input>
</div>
<div class="form-group">
<form:checkbox path="requestPhotos" class="form-control" placeholder="requestPhotos"></form:checkbox>
</div>
<div class="form-group">
<form:checkbox path="requestVideos" class="form-control" placeholder="requestVideos"></form:checkbox>
</div>
<div class="form-group">
<form:checkbox path="requestAudio" class="form-control" placeholder="requestAudio"></form:checkbox>
</div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
</div>
<c:import url="/postbase.jsp" />
