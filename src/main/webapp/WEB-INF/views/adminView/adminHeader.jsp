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
<link rel="stylesheet" type="text/css" href="/resources/css/adminHeader.css">
        
</head>
<body>
            
    <div class="headWrap">
       
        <div id="headLogo"> <img src="/resources/images/logo.png"> </div>
        
        <div id="status">                        
           <span style="float: right; margin: 5px;">
            <div class="d-grid gap-2 mx-auto">                
              <button class="btn btn-danger" type="button" onclick="logout();" > 로그아웃</button>                  
            </div>  
           </span>
           
           <span style="float: right; margin: 5px;">
            <a tabindex="0" class="btn btn-outline-danger" role="button" data-bs-toggle="popover" data-bs-trigger="focus" title="누르면 창 종료" 
            data-bs-content="담당자 연락처: ###-####-####">도움요청</a>
           </span>
        </div>
        
    </div>
            
    <script>
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl)
    })
    </script>
    
    <script>
        function logout(){
            location.replace("/admin/adminLogout.do");
        }
    </script>
    
</body>
</html>