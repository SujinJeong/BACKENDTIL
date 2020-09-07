<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>중간고사 대체 과제-midterm</title>
    </head>
    <body>
		공연일정:
		<table border="1">
		<tr>
		   <th>순번</th>
		   <th>ID</th>
		   <th>이름</th>
		   <th>종류</th>
		   <th>곡명</th>
		   <th>공연시간</th>
		   <th>공연 요청사항</th>
		</tr>
		<c:forEach var="mi" items="${members}" varStatus="status">
		   <tr>
		   <td><c:out value="${status.count}" /></td>
		   <td><a href="<c:url value='/members/get?email=${mi.email}' />"><c:out value="${mi.email}" /></a></td>
		   <td><c:out value="${mi.name}" /></td>
		   <td><c:out value="${mi.type}" /></td>
		   <td><c:out value="${mi.song}" /></td>
		   <td><c:out value="${mi.time}" /></td>
		   <td><c:out value="${mi.requirements}"/></td>
		   <td><a href="<c:url value='/members/delete?email=${mi.email}' />"><c:out value="삭제" /></a></td>
		   </tr>
		</c:forEach>
		</table>
		<p><a href="<c:url value='/newevent/step1' />">참가신청</a></p>
	</body>
</html>
