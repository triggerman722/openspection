<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />

  <div class="container-fluid">
	   <div class="container">
<form action="/posts/search" method="GET" class="form">
                                                <div class="form-row">
                                                        <div class="col-md-5">
                                        <input type="text" class="form-control col-md-12 mr-2" placeholder="what" name="keywords" />
                                                        </div>
                                                        <div class="col-md-5">
                                        <input type="text" class="form-control col-md-12 mr-2" placeholder="where" name="location" />
                                </div>
                                                        <div class="col-md-2">
<button class="btn btn-success col-md-12" type="submit">
                                                                                <i class="fa fa-search"></i>
                                                                        </button>
                                                        </div>
                                                </div>
                    </form>
		   <h4 class="my-4">Search Results</h4>
		   <hr class="my-4">
		   <ul class="list-unstyled">
<c:forEach var="weather" items="${searchresults}">
			<li class="media">
				<img class="mr-3" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2264%22%20height%3D%2264%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2064%2064%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_1628373be6c%20text%20%7B%20fill%3Argba(255%2C255%2C255%2C.75)%3Bfont-weight%3Anormal%3Bfont-family%3AHelvetica%2C%20monospace%3Bfont-size%3A10pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_1628373be6c%22%3E%3Crect%20width%3D%2264%22%20height%3D%2264%22%20fill%3D%22%23777%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2213.5%22%20y%3D%2236.8%22%3E64x64%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" alt="Generic placeholder image">
 				<div class="media-body">
				<h5 class="mt-0 mb-1"><a href="${contextPath}/users/${weather["username"]}/posts">${weather["username"]}</a></h5>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
				<p>
					<a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Popular</a>
					<a href="#" class="badge badge-primary"><i class="fa fa-tag mr-1"></i>Location-based</a>
					<a href="#" class="badge badge-danger"><i class="fa fa-tag mr-1"></i>Urgent</a>
					<span class="float-right text-muted">posted on Dec 14, 2008 by <a href="/users/gmartin">gmartin</a></span>
				</p>
				</div>
 			</li>
			<hr class="my-4">
</c:forEach>
		</ul>
	</div>
</div>
<c:import url="/postbase.jsp" />
