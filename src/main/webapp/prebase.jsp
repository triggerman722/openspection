<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${pageTitle}</title>

    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:800" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type='text/css'>
    <link href="resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<nav class="navbar navbar-expand-lg" style="height:50px;">
		<div class="container">
			<a class="navbar-brand" href="/" style="font-family: 'Alegreya Sans', sans-serif;font-size:32px">openspection</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<form class="form-inline navbar-nav mr-4" action="/users/search" method="GET">
                			<div class="input-group">
								<input type="text" class="form-control" placeholder="Search for...">
								<span class="input-group-append">
									<button class="btn btn-success" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
		    			</form>
					</li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                	<li class="nav-item"><a class="nav-link mr-4" href="/login">Log In</a></li>
					<li class="nav-item"><a class="btn btn-primary" href="/posts/create">Sign Up</a></li>
                    </c:when>
                </c:choose>


                </ul>
			</div>
		</div>
	</nav>
	
    <div class="jumbotron-fluid leading">
		<div class="container-fluid unleading py-5">
		<div class="container py-5">
                <h1 class="display-4">Inspect Anything!</h1>
				<p class="lead">Find openspections near you and start earning scratch!</p>
				<p class=">
                    <form action="/posts/search" method="get" class="form">
						<div class="form-row">
							<div class="col-md-5">
                        		<input type="text" class="form-control col-md-12 mr-2" placeholder="what" name="query" />
							</div>
							<div class="col-md-5">
                        		<input type="text" class="form-control col-md-12 mr-2" placeholder="where" name="location" />
                        	</div>
							<div class="col-md-2">
								<input type="submit" class="btn btn-success col-md-12" />
							</div>
						</div>
                    </form>
                </p>
		</div>
	</div>
    </div>

