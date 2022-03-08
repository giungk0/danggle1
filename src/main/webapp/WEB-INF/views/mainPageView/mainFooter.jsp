<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/mainFooter.css">    
</head>
<body>
    <footer class="footer-clean" style="height: 235px;width: 100%;background: #fafbfe;">
        <hr style="color: var(--orange);height: 2px;background: #FD6F22;">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4 col-md-3 item">
                    <h3>서비스</h3>
                    <ul>
                        <li>반려견 일지</li>
                        <li>병원정보</li>
                        <li>커뮤니티</li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>안내</h3>
                    <ul>
                        <li>댕글?</li>
                        <li>오늘의 댕댕?</li>
                        <li>위치</li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>이용방침</h3>
                    <ul>
                        <li> <a id="aIndex">관리자</a></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
                <div class="col-lg-3 item social">
                    <p class="copyright">오늘의 댕댕 © 2022</p>
                </div>
            </div>
        </div>
    </footer>
    
     <script>
    	$('#aIndex').click(function(){
    		    		
    		if( confirm('관리자 페이지로 이동합니다, 현재 상태에서 로그아웃 합니다') ){
    			location.replace("/admin/adminIndex.do");    			
    		}else{
    			return false;
    		}
    	});
    </script>
    
</body>
</html>