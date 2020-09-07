<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세 정보</title>
</head>
<body>
<ul>
   <li>ID: ${member.email}</li>
   <li>이름: ${member.name}</li>
   <li>전화번호: ${member.phonenum}</li>
   <li>주소: ${member.address.street} ${member.address.city} (우편번호: ${member.address.zipcode})</li>
   <li>공연 종류: ${member.type}</li>
   <li>곡명: ${member.song }</li>
   <li>공연시간: ${member.time }</li>
   <li>공연 제반시설 요구사항: ${member.requirements }</li>
   <li>첫 공연 여부: ${member.isFirst }</li>
</ul>

<p><a href="<c:url value='/index' />">Go to index</a></p>
</body>
</html>