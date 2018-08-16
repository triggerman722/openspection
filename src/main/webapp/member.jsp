<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="jumbotron-fluid" style="background-size:cover;background: url(${user.getBannerurl()}) no-repeat">
        <div class="container-fluid py-5">
                <div class="container py-5">
                </div>
        </div>
</div>
<div class="container">
<div class="row">
<div class="col-md-4">
<img class="pb-2 w-100 rounded" src="${user.getPhotourl()}" style="border:17px solid #fff;margin-top:-50px">
</div>
<div class="col-md-8">
<c:if test="${editable}">
<a class="pull-right" href="${contextPath}/members/${user.getUsername()}/edit">Edit</a>
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
<div class="media">
<img class="align-self-center mr-1 rounded-circle" src="//3.bp.blogspot.com/-zOuZdReYw3U/Wu3aZYJKNUI/AAAAAAAAAAQ/6bbYKqhpstARxLfoAWQrSENJevkjWCJcQCK4BGAYYCw/s1600/15.jpg" style="width:32px">
<div class="media-body my-auto">
<p class="m-0"><small><strong>Written by Kyle Mayers</strong></small></p>
<p class="m-0 text-muted"><small>August 03, 2018
<i class="fa fa-comment ml-3 mr-1"></i>0</small></p>
</div>
</div>
</div>
</div>
</div>
<div class="container">
<p class="text-muted text-uppercase">openspections</p>
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
</div>
<c:import url="/postbase.jsp" />
