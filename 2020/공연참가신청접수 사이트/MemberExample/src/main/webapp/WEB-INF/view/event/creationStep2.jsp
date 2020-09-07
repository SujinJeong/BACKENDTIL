<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>공연 참가 신청 - Step2</title>
</head>
<body>
<h2>공연 참가 신청 - Step2</h2>
<form:form modelAttribute="regReq" action="step3">

<label for="type">공연종류</label>: 
<form:select path="type">
<form:option value="Instrumentalist">Instrumentalist</form:option>
<form:option value="Singer">Singer</form:option>
<form:option value="OneManBand">OneManBand</form:option>
<form:option value="Juggler">Juggler</form:option>
</form:select>
<form:errors path="type"/> <br/>

<label for="song">곡명</label>: 
<form:input path="song"/>
<form:errors path="song"/> <br/>

<label for="time">공연시간</label>: 
<form:input path="time" />
<form:errors path="time"/> <br/>

<label for="requirements">공연 제반시설 요구사항</label>: 
<form:input path="requirements" />
<form:errors path="requirements"/> <br/>

<label>첫 공연?  
<form:checkbox path="isFirst" />
</label><br/>
<form:errors path="isFirst"/> <br/>

<a href="step1">[이전 단계로]</a>
<input type="submit" value="다음 단계로" />

<p><a href="<c:url value='/index' />">Go to index</a></p>
</form:form>
</body>
</html>