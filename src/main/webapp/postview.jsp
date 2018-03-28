<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="container">
<div class="row">
	<div class="col-md-10">
		<h1 class="text-uppercase">${singlepost.title}</h1>
	</div>
	<div class="col-md-2 text-right my-auto"><span>Openspection #${singlepost.id}</span></div>
</div>

<h2>Job Posting Details</h2>
<div class="row">
	<div class="col-md-4">
		<dl class="dl-horizontal">
			<dt>Posted Date</dt>
			<dd>${singlepost.datecreated}</dd>
		</dl>
                <dl class="dl-horizontal">
                        <dt>Respond By</dt>
                        <dd>${singlepost.dateexpired}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Word Count</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Accent</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Role</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Style</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
	</div>
	<div class="col-md-4">
		<dl class="dl-horizontal">
			<dt>Language</dt>
			<dd>${singlepost.datecreated}</dd>
		</dl>
                <dl class="dl-horizontal">
                        <dt>Gender</dt>
                        <dd>${singlepost.dateexpired}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Age Range</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
                <dl class="dl-horizontal">
                        <dt>Category</dt>
                        <dd>${singlepost.datecreated}</dd>
                </dl>
	</div>
</div>
<h3>Job Description</h3>
${singlepost.description}
<div class="well">
<h2>Start Applying for Openspections Now!</h2>
This Openspection is open and accepting applications. With a <a href="">Premium Openspection.com Membership</a> you can:
<ul>
<li><strong>View</strong> full Openspection posting</li>
<li><strong>Submit</strong> custom Openspection credentials</li>
<li><strong>Get Hired</strong> and paid securely</li>
</ul>
If you are a premium member, <a href="">log in</a> to submit your openspection capabilities.
 To purchase a Premium Membership and start to this and many other job postings today, <a href="">sign up now</a>.
</div>
</div>
<c:import url="/postbase.jsp" />
