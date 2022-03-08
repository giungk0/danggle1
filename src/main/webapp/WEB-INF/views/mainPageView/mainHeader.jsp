<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/mainHeader.css">
</head>

<body>

    <div id="wrap">
        <div id="head"> <div> </div> </div>
        
        <div id="menuWrap"> 
           
            <div id="menuBox">
                <span class="headUnderline">  <span id="diary">내 반려견 일기</span> </span>
              <span class="headUnderline">  <span id="area">멍세권 </span> </span>
              <span class="headUnderline">  <span id="community">커뮤니티</span> </span>
              <span class="headUnderline">  <span id="vet">동물병원 찾기</span> </span>
            </div>
         
        <c:choose>
            <c:when test="${sessionScope.member != null }" >    
                <div class="rightoBox">
                    <span id="info"> ${(sessionScope.member.nickname)} </span> 
                </div>
            
                <div clss="leftBox"> 
                    <span id="logout">로그아웃</span>
                </div>
             </c:when> 
             
            <c:otherwise>
            <c:if test="${sessionScope.member == null }" > 
            
           <div class="rightBox"> 
              <span id="join">회원가입</span>
           </div> 
            
           <div class="leftBox">
              <span id="login">로그인</span> 
           </div>
           </c:if>    
            </c:otherwise>    
        </c:choose>        
        </div>
        
    </div>    
    
    
    <script>
   	   <!-- 로그아웃 이벤트는 여기에 걸어주시면 됩니다 -->
    	$('#logout').click(function(){
    		location.replace("/member/logout.do");
    	});    
        
        $('#head>div').click(function(){
            location.replace("/");
        });
        
        $('#diary').click(function(){
            location.replace("/myPage/diaryPage.do");
        });
        
        $('#area').click(function(){
				alert('멍세권으로 이동');
        });
        
        $('#community').click(function(){
            location.replace("/board/community.do");
        });
        
        $('#vet').click(function(){
            location.replace("/hospital/hospitalInfo.do");
        });
        
        $('#login').click(function(){
        	location.replace("/resources/staticViews/member/login.jsp");
        });
        
        $('#join').click(function(){
        	location.replace("/resources/staticViews/member/join.jsp");
        });
        
        $('#info').click(function(){
            location.replace("/myPage/memberInfoPage.do");
        });
        
    </script>
    
</body>
</html>