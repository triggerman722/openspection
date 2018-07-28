<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container-fluid">
	<div class="container">
		<form action="/posts/search" method="GET" class="form">
			<div class="form-row">
				<div class="col-md-5">
                                        <input type="text" class="form-control col-md-12 mr-2" placeholder="what" name="keywords" value="${keywords}" />
				</div>
				<div class="col-md-5">
                                        <input type="text" class="form-control col-md-12 mr-2" placeholder="where" name="location" id="pac-location" value="${location}" />
				</div>
				<div class="col-md-2">
					<button class="btn btn-success col-md-12" type="submit"><i class="fa fa-search"></i></button>
				</div>
				<input type ="hidden" name="latitude" id="hid-latitude" />
				<input type ="hidden" name="longitude" id="hid-longitude" />
			</div>
                    </form>
	</div>
</div>
