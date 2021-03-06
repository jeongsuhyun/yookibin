<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${root }/css/alertify.js-0.3.11/lib/alertify.min.js"></script>
<link rel="stylesheet" href="${root }/css/alertify.js-0.3.11/themes/alertify.core.css"/>
<script src="${root }/css/sweetalert-master/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/css/sweetalert-master/dist/sweetalert.css"/>
</head>
<body>
	<c:if test="${check==0 }">
		<script type="text/javascript">
			/* alertify.alert("삭제되지 않았습니다.");
			location.href="${root}/eventBoard/managerRead.do?event_code=${event_code}&join_code=${join_code}&pageNumber=${pageNumber}&eventPageNumber=${eventPageNumber}&group_number=${group_number}&sequence_number=${sequence_number}&sequence_level=${sequence_level}"; */
			swal({ 
				  title: "BAD!",
				  text: "삭제되지 않았습니다.",
				  type: "error" 
				  },
				  function(){
					  window.location.href ="${root}/eventBoard/managerRead.do?event_code=${event_code}&join_code=${join_code}&pageNumber=${pageNumber}&eventPageNumber=${eventPageNumber}&group_number=${group_number}&sequence_number=${sequence_number}&sequence_level=${sequence_level}";
				});
		</script>
	</c:if>
	
	<c:if test="${check>0 }">
		<script type="text/javascript">
			/* alertify.alert("삭제되었습니다.");
			location.href="${root}/eventBoard/managerList.do?event_code=${event_code}&pageNumber=${pageNumber}&eventPageNumber=${eventPageNumber}&group_number=${group_number}&sequence_number=${sequence_number}&sequence_level=${sequence_level}"; */
			
			swal({ 
				  title: "GOOD!",
				  text: "삭제되었습니다.",
				  type: "success" 
				  },
				  function(){
				    window.location.href ="${root}/eventBoard/managerList.do?event_code=${event_code}&pageNumber=${pageNumber}&eventPageNumber=${eventPageNumber}&group_number=${group_number}&sequence_number=${sequence_number}&sequence_level=${sequence_level}";
				});
			
		</script>
	</c:if>
</body>
</html>