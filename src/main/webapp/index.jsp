<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:import url="/prebase.jsp" />
<div class="jumbotron-fluid leading">
	<div class="container-fluid unleading py-5">
                <div class="container py-5">
                <h1 class="display-4">Inspect Anything!</h1>
                	<p class="lead">Find openspections near you and start earning scratch!</p>
                        <p>
				<form:form action="/posts/search" method="POST" modelAttribute="searchrequest" class="form">
                                <div class="form-row">
                                	<div class="col-md-5">
						<form:input type="text" path="keywords" class="form-control col-md-12 mr-2" placeholder="keywords" autofocus="true"></form:input>
                                        </div>
                                        <div class="col-md-5">
						<form:input type="text" path="location" class="form-control col-md-12 mr-2" placeholder="location" autofocus="true" id="pac-location"></form:input>
                                	</div>
                                        <div class="col-md-2">
						<button class="btn btn-success col-md-12" type="submit"><i class="fa fa-search"></i></button>
                                        </div>
                                </div>
                    </form:form>
                </p>
                </div>
        </div>
    </div>
<c:import url="/postbase.jsp" />
