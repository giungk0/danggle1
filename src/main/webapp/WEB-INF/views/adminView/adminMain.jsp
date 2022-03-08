<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>      
<link rel="stylesheet" type="text/css" href="/resources/css/adminMain.css">
</head>
            
<body>
   
   <div class="wrap"> 
   
	<c:choose>
		<c:when test="${sessionScope.adminVO != null }">
		
       <div id="header">  <%@ include file="/WEB-INF/views/adminView/adminHeader.jsp" %> </div>
       
       <div id="body">
           <div id="aside"> <%@ include file="/WEB-INF/views/adminView/adminAside.jsp" %> </div>
           <div id="contents">             
               <img src="/resources/images/init.png"/>
               <h1> 관리자 페이지 입니다</h1>
               <h1>좌측의 메뉴에서 필요한 기능을 선택해 주세요</h1>
           </div>
       </div> 
       </c:when>
       
      <c:otherwise>
      	<H2>관리자 계정 로그인이 필요합니다</H2>
      		<a href="/admin/adminIndex.do"> 로그인으로 이동 </a>
      </c:otherwise>      
	</c:choose>
	       
   </div>
    
</body>
</html>