<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="jumbotron-fluid bg-secondary" style="max-height:250px;overflow:hidden">
        <div class="container-fluid p-0">
<img class="w-100" src="${user.getBannerurl()}">
        </div>
</div>


<div class="container">
	<div class="row">
		<div class="col-md-2 rounded p-0 bg-white" style="border:17px solid #fff;margin-top:-50px;max-width:200px;">
			<img class="w-100 rounded" src="${user.getPhotourl()}">
		</div>
		<div class="col-md-10 p-3">
			<c:if test="${editable}">
			<a class="pull-right btn btn-info" href="${contextPath}/members/${user.getUsername()}/edit">Edit</a>
			</c:if>
			<h2>${user.getUsername()}</h2>
			<p class="text-muted">${user.getDescription()}</p>
			<p>
				<a href="${user.getLinkedinurl()}" class="text-muted"><i class="fa fa-linkedin"></i></a>
				<a href="${user.getTwitterurl()}" class="text-muted"><i class="fa fa-twitter"></i></a>
				<a href="${user.getFacebookurl()}" class="text-muted"><i class="fa fa-facebook"></i></a>
				<a href="${user.getGithuburl()}" class="text-muted"><i class="fa fa-github"></i></a>
				<a href="${user.getWebsiteurl()}" class="text-muted"><i class="fa fa-globe"></i></a>
				<a href="${user.getBlogurl()}" class="text-muted"><i class="fa fa-rss"></i></a>
			</p>
		</div>
	</div>
	<di class="row">
	<div class="container">
		<p class="text-muted text-uppercase">openspections</p>
		<c:if test="${empty userposts}">
		<c:if test="${editable}">
		<p class="text-muted">You have no Openspections. <a href="/posts/create" class="btn btn-success">Get an inspection</a> right now!</p>
		</c:if>
		<c:if test="${!editable}">
		<p class="text-muted">${user.getUsername()} has no Openspections.</p>
		</c:if>
                        <hr class="my-4">
		</c:if>
		<c:forEach var="userpost" items="${userposts}">
                        <li class="media">
                                <img class="mr-3 rounded-circle" src="/resources/img/back0.jpg" width="48" height="48">
                                <div class="media-body">
                                <span class="float-right text-muted">4w</span>
                                <h5 class="mt-0 mb-1"><a href="${contextPath}/posts/${userpost["id"]}">${userpost["title"]}</a></h5>${userpost["description"]}
                                <p>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
                                        <a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
                                </p>
                                </div>
                        </li>
                        <hr class="my-4">
		</c:forEach>
<p class="text-muted text-uppercase">applications</p>
                <c:if test="${empty userapplications}">
                <p class="text-muted">You have no applcations. When you apply to an Openspection, it will appear here.</p>
                        <hr class="my-4">
                </c:if>
<c:forEach var="userapplication" items="${userapplications}">
                        <li class="media">
                                <img class="mr-3 rounded-circle" src="/resources/img/back0.jpg" width="48" height="48">
                                <div class="media-body">
                                <span class="float-right text-muted">4w</span>
                                <h5 class="mt-0 mb-1"><a href="${contextPath}/posts/${userapplication.getPost().getId()}/application/${userapplication.getId()}">${userapplication.getPost().getTitle()}</a></h5>${userapplication.getPost().getDescription()}
                                <p>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
                                        <a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
                                </p>
<c:if test="${editable}">
				<p><a href="${contextPath}/posts/${userapplication.getPost().getId()}/application/${userapplication.getId()}/cancel">Cancel</a></p>
</c:if>
                                </div>
			</li>
                        <hr class="my-4">
</c:forEach>
<p class="text-muted text-uppercase">inspections</p>
                <c:if test="${empty userinspections}">
                <p class="text-muted">You have no inspections to do. When you get hired for inspections jobs, they will appear here.</p>
                        <hr class="my-4">
                </c:if>
<c:forEach var="userinspection" items="${userinspections}">
                        <li class="media">
                                <img class="mr-3 rounded-circle" src="/resources/img/back0.jpg" width="48" height="48">
                                <div class="media-body">
                                <span class="float-right text-muted">4w</span>
                                <h5 class="mt-0 mb-1"><a href="${contextPath}/posts/inspections/${userinspection.getId()}">${userinspection.getTitle()}</a></h5>${userinspection.getDescription()}
                                <p>
                                        <a href="/posts/${userinspection.getPost().getId()}" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>${userinspection.getPost().getTitle()}</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
                                        <a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
                                </p>
<c:if test="${editable}">
                                <p><a class="btn btn-success mr-1" href="${contextPath}/posts/${userinspection.getPost().getId()}/inspections/${userinspection.getId()}/">Start</a></p>
                                <p><a class="btn btn-primary mr-1 disabled" href="${contextPath}/posts/${userinspection.getId()}/">Resume</a></p>
                                <p><a class="btn btn-danger" href="${contextPath}/posts/${userinspection.getId()}/cancel">Delete</a></p>
</c:if>
                                </div>
                        </li>
                        <hr class="my-4">
</c:forEach>
</div>
<c:import url="/postbase.jsp" />
