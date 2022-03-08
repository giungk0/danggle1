<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>      
<link rel="stylesheet" type="text/css" href="/resources/css/adminLogin.css">    
</head>
<body>
   
   <div id="wrap">       
       
       <div id="inputBox">
           
           <div id="margin">
                              
                 <fieldset> <legend style="text-align: center;">로그인</legend>               
                 <br>
              ID: <br><input type="text" name="adminID" id="adminId" /> <br>
              PWD: <input type="password" name="adminPWD" id="adminPwd" />  <br> <br>                                 
                 <input type="submit" value="로그인" onclick="return login();">
                  </fieldset>                 	                                                                                       
           
           </div> 
           
          <button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#mail" id="modal"> 관리자 연락 </button>
           
       </div>
       

<div class="modal fade" id="mail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">관리자에게 메일을 발송합니다</h5>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">발신자:</label>
            <input type="text" class="form-control" id="recipient-name" maxlength="20" placeholder=" (소속/성함) 으로 기재 바랍니다" >
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">전달사항:</label>
            <textarea class="form-control" id="message-text" maxlength="50" style="resize: none;" rows="5" placeholder="(50자 제한)"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-outline-danger" onclick="send();">발송</button>
      </div>
    </div>
  </div>
</div>    
          
   </div>
   
   <script>		
	function login(){
		var adminId = $('#adminId').val();
		var adminPwd = $('#adminPwd').val();
		
		if (adminId.length == 0 )  {
       		 alert('ID를 입력하세요');
       		 return false;
       	 } else if ( adminPwd.length == 0 ) {
       		alert('PW를 입력하세요');
       		return false;   
       		
		 }else{				
			$.ajax({
			 url : "/admin/adminLogin.do",
			 type : "post",            
			 data : {"adminID":adminId, "adminPWD":adminPwd},
			        
			 success : function(data) {           
			    if (data == 'true')	{            	
			      alert('로그인 성공');
			      location.replace("/admin/adminMain.do");
			    }else{
			 	  alert('로그인 실패');
			 	  location.replace("/admin/adminIndex.do");
			    }			        
			},
			 error : function(data) {
			 	alert("ajax error");
			    }
		})
		}
	};		
       
   </script>
      
   <script>
   	function send(){
		
		if( window.confirm('메일을 발송 하시겠습니까?') ){	

		var title = "오늘의 댕댕";
		var name = $('#recipient-name').val();
		var text = $('#message-text').val();

		var data = {
			    service_id: 'service_rh9wwuk',
			    template_id: 'template_ph9swvu',
			    user_id: 'user_tRmE2v5Kxa2R2cg8A61U1',
			    template_params: {
			    	'title': title,	    	
			        'name': name,
			        'message': text	        
			    }
			};
		
		$.ajax('https://api.emailjs.com/api/v1.0/email/send', {
	    	type: 'POST',
	    	data: JSON.stringify(data),
	    	contentType: 'application/json'
		}).done(function() {
	    	alert('메일을 보냈습니다');
	    	$('#mail').modal('hide');
		}).fail(function(error) {
	    	alert('전송오류 발생 ' + JSON.stringify(error));
		});
	  }		
	}
    </script>
    
</body>
</html>