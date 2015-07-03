<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이벤트 등록하기</title>
<script type="text/javascript" src="${root }/smarteditor/js/HuskyEZCreator.js"></script>
<script type="text/javascript" src="${root }/css/eventBoard/script.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/css/eventBoard/style.css">
</head>
<body>
	<form class="form_style"  action="${root }/eventBoard/write.do"  method="post" onsubmit="return checkForm(this)" enctype="multipart/form-data">	
		<input type="hidden" name="event_code" value="${event_code}"/>
		<input type="hidden" name="group_number" value="${group_number}"/>
		<input type="hidden" name="sequence_number" value="${sequence_number}"/>
		<input type="hidden" name="sequence_level" value="${sequence_level}"/>
		<input type="hidden" name="pageNumber" value="${pageNumber}"/>
		
		<h4>event_code : ${event_code}</h4>
		<h4>group_number : ${group_number}</h4>
		<h4>sequence_number : ${sequence_number}</h4>
		<h4>sequence_level : ${sequence_level}</h4>
		<h4>pageNumber : ${pageNumber}</h4>
			
		<div style="width:598px; height:15px; border-width:2px; text-align:right; padding:15px 0px 0px 0px; border-bottom-width:0px;">
				<a href="${root}/eventBoard/list.do">글목록</a>
		</div>
			
		<div class="line">
			<label class="title">작성자</label>
			<span class="content">
				<input type="text" name="writer" value="${nickName }"/>
			</span>
		</div>
		
		<div class="line">
			<label class="title">이벤트 기간</label>
			<c:if test="${event_code==0 }">
				<span class="content"><input type="text" size="50" name="event_period"/></span>	
			</c:if>
			<c:if test="${eventcode!=0 }">
				<span class="content"><input type="text" size="50" name="event_period" value="${eventBoard.event_period }"/></span>
			</c:if>
					
		</div>
		
		<div class="line">
			<label class="title">이벤트 제목</label>
			<c:if test="${event_code==0 }">
				<span class="content"><input type="text" size="50" name="event_title"/></span>
			</c:if>
			<c:if test="${event_code!=0 }">
				<span class="content"><input type="text" size="50" name="event_title" value="[당첨자 발표] ${eventBoard.event_title }"/></span>
			</c:if>
						
		</div>
		
		<div class="line" style="height:230px;">
			<label class="title" style="height:230px;">이벤트 내용</label>
			<c:if test="${event_code==0 }">
				<span class="content" style="height:230px;">
					<textarea rows="14" cols="58" name="event_content"></textarea>
				</span>
			</c:if>
			<c:if test="${event_code!=0 }">
				<span class="content" style="height:230px;">
					<textarea rows="14" cols="58" name="event_content">
글번호  아이디  닉네임					
						<c:forEach var="winner" items="${winnerList }">
${winner.join_code}      ${winner.id }        ${winner.join_writer }
						</c:forEach>
					</textarea>
				</span>
			</c:if>
		</div>
		
		<div class="line">
			<label class="title">이벤트 차감 포인트</label>
			<c:if test="${event_code==0 }">
				<span class="content"><input type="text" size="50" name="event_point"/></span>
			</c:if>
			<c:if test="${event_code!=0 }">
				<span class="content"><input type="text" size="50" name="event_point" value="${eventBoard.event_point }"/></span>
			</c:if>						
		</div>
		
		<div class="line">
			<label class="title">이벤트 경품</label>
			<c:if test="${event_code==0 }">
				<span class="content"><input type="text" size="50" name="event_giveaway"/></span>
			</c:if>		
			<c:if test="${event_code!=0 }">
				<span class="content"><input type="text" size="50" name="event_giveaway" value="${eventBoard.event_giveaway }"></span>
			</c:if>	
		</div>
		
		
		<div class="line">
			<label class="title">이벤트 사진 파일</label>
			<span class="content">
				<input type="file" name="file"/>
			</span>
		</div>
		
<%-- 		
		<c:if test="${event_code==0 }">
			<span style="display:none">
				<input type="file" name="file" />
			</span>			
		</c:if>
 --%>						
		<div class="line" style="width:598px; border-width:2px; text-align:center;">
			<input type="submit" value="글쓰기"/>
			<input type="reset" value="다시작성"/>
			<input type="button" value="목록보기" onclick="location.href='${root}/eventBoard/list.do'"/>
		</div>
		
	</form>
</body>
</html>