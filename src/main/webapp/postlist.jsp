<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="container">
<table border="1">
    <tr>
        <th>DATE</th>
        <th>CONDITION</th>
        <th>TEMP. HIGH</th>
        <th>TEMP. LOW</th>
    </tr>
    <c:forEach var="weather" items="${postList}">
        <tr>
            <td><a href="${contextPath}/posts/${weather["id"]}">${weather["title"]}</a></td>
            <td>${weather["description"]}</td>
            <td align="center">${weather["latitude"]}&#x2103;</td>
            <td align="center">${weather["longitude"]}&#x2103;</td>
        </tr>
    </c:forEach>
</table>
</div>
<c:import url="/postbase.jsp" />
