<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<div class="container">
<table border="1">
    <tr>
        <th>DATE</th>
    </tr>
    <c:forEach var="weather" items="${searchresults}">
        <tr>
            <td><a href="${contextPath}/${weather["username"]}/posts">${weather["username"]}</a></td>
        </tr>
    </c:forEach>
</table>
</div>
<c:import url="/postbase.jsp" />
