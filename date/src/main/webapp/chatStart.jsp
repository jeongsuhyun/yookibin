<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chatStart(root){
		var url=root+"/chatStart.do";
		window.open(url,"chating","width=540,height=520,resizable=no");		
	}
</script>
</head>
<body>
	<input type="button" value="채팅하기" onclick="chatStart('${root}')"/>
</body>
</html>