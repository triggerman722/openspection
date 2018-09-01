<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />

<div class="container-fluid">
	<div class="container">
		<c:if test="${applyable}">
		<a href="/posts/${singlepost.id}/application" class="float-right btn btn-success" role="button">Apply</a>
		</c:if>

		<div class="media">
			<img class="mr-3 rounded-circle" src="/resources/img/back0.jpg" alt="Generic placeholder image" width="48" height="48">
			<div class="media-body">
				<h4 class="mt-0">${singlepost.title}</h4>
				<p>${singlepost.description}</p>
				<p class="text-muted"><small>${singlepost.datecreated}</small></p>
				<div class="media">
				<img class="align-self-center mr-1 rounded-circle" src="${singleuser.getPhotourl()}" style="width:32px;height:32px;">
				<div class="media-body my-auto">
				<p class="m-0"><small><strong>Posted by <a href="/members/${singleuser.getUsername()}">${singleuser.getUsername()}</a></strong></small></p>
				<p class="m-0 text-muted"><small>${singlepost.datecreated}
<i class="fa fa-comment ml-3 mr-1"></i>0</small></p>
 			<i class="fa fa-money align-self-center mr-3"></i>
                        <p class="my-0 text-muted"><small>Offered compensation</small></p>
                        <p class="my-0"><small>$42.123455</small></p>
				</div>
				</div>
			</div>
		</div>
                <p class="text-muted text-uppercase">applicants</p>
                <c:if test="${empty applications}">
                <p class="text-muted">This Openspection has no applicants.</p>
                </c:if>
                <c:forEach var="applicant" items="${applications}">
                        <li class="media">
                                <img class="mr-3 rounded-circle" src="${applicant.getUser().getPhotourl()}" width="48" height="48">
                                <div class="media-body">
      			        <c:if test="${editable}">
                		<a href="/posts/${singlepost.id}/application/${applicant.id}/decline" class="float-right btn btn-warning" role="button">Decline</a>
                		<a href="/posts/${singlepost.id}/application/${applicant.id}/hire" class="float-right btn btn-success mr-1" role="button">Accept</a>
                		</c:if>
                                <h5 class="mt-0 mb-1"><a href="${contextPath}/members/${applicant.getUser().getUsername()}">${applicant.getUser().getUsername()}</a></h5>
                                <p>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
                                        <a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
                                </p>
                                </div>
                        </li>
                        <hr class="my-4">
                </c:forEach>
 <p class="text-muted text-uppercase">inspectors</p>
                <c:if test="${empty inspections}">
                <p class="text-muted">This Openspection has no inspectors.</p>
                </c:if>
                <c:forEach var="inspection" items="${inspections}">
                        <li class="media">
                                <img class="mr-3 rounded-circle" src="${inspection.getUser().getPhotourl()}" width="48" height="48">
                                <div class="media-body">
                                <h5 class="mt-0 mb-1"><a href="${contextPath}/members/${inspection.getUser().getUsername()}">${inspection.getUser().getUsername()}</a></h5>
                                <p>
                                        <a href="/posts/${singlepost.getId()}/inspections/${inspection.getId()}" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Report</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
                                        <a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
                                        <a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
                                </p>
                                </div>
                        </li>
                        <hr class="my-4">
                </c:forEach>
	</div>
</div>
<c:import url="/postbase.jsp" />
