<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>공연 신청 완료</title>
</head>
<body>
<h2>공연 참가 접수완료</h2>
${regReq.name} 님의 공연 신청을 접수했습니다.<br>

<ul>
   <li>ID: ${regReq.email}</li>
   <li>이름: ${regReq.name}</li>
   <li>전화번호: ${regReq.phonenum}</li>
   <li>주소: ${regReq.address.street} ${regReq.address.city} (우편번호: ${regReq.address.zipcode})</li>
   <li>공연 종류: ${regReq.type}</li>
   <li>곡명: ${regReq.song }</li>
   <li>공연시간: ${regReq.time }</li>
   <li>공연 제반시설 요구사항: ${regReq.requirements }</li>
   <li>첫 공연 여부: ${regReq.isFirst }</li>
</ul>

접수일시: ${regReq.regTime}<br>

<p><a href="<c:url value='/index' />">Go to schedule</a></p>
</body>
</html>