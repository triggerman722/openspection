<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
    <form:form method="POST" modelAttribute="postForm" class="form-signin">
        <h2 class="form-signin-heading">Create your post</h2>
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

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
<c:import url="/postbase.jsp" />
