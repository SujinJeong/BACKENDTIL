<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>공연 참가 신청 - Step3</title>
</head>
<body>
<h2>공연 참가 신청 - Step3</h2>
<form:form modelAttribute="regReq" action="done">

다음 정보로 신청하시겠습니까? <br>

<ul>
   <li>ID: ${regReq.email}</li>
   <li>이름: ${regReq.name}</li>
   <li>전화번호: ${regReq.phonenum}</li>
   <li>주소: ${regReq.address.street} ${regReq.address.city} (우편번호: ${regReq.address.zipcode})</li>
   <li>공연 종류: ${regReq.type}</li>
   <li>곡명: ${regReq.song }</li>
   <li>공연시간: ${regReq.time }</li>
   <li>공연 제반시설 요구사항: ${regReq.requirements}</li>
   <li>첫 공연 여부: ${regReq.isFirst }</li>
</ul>

<br>
<a href="step2">[이전 단계로]</a>
<input type="submit" value="확인" <c:url value='/member/register' />/>
</form:form>

<p><a href="<c:url value='/index' />">Go to index</a></p>
</body>
</html>