<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:import url="/prebase.jsp" />
<table border="1">
    <tr>
        <th>DATE</th>
    </tr>
    <c:forEach var="weather" items="${searchresults}">
        <tr>
            <td><a href="${contextPath}/posts/${weather["username"]}">${weather["username"]}</a></td>
        </tr>
    </c:forEach>
</table><c:import url="/postbase.jsp" />
