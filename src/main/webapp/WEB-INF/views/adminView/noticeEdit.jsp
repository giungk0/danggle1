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
<link rel="stylesheet" type="text/css" href="/resources/css/noticeEdit.css">
</head>
          
<body>
   
<div class="wrap"> 
     
       <div id="header">  <%@ include file="/WEB-INF/views/adminView/adminHeader.jsp" %> </div>
       
       <div id="body">
          
         <div id="aside">  <%@ include file="/WEB-INF/views/adminView/adminAside.jsp" %>  </div>
           
             <div class="contents">
                       
              <div id="writeForm">                 
               <table class="table table-hover">    
                    
                   <thead>
                   	<tr>
                      <th> <H2 > 공지사항을 수정합니다 </H2> 
						글번호: <c:out value="${requestScope.map.notice.getNoticeNo()}" />
						<input type = "hidden" name="noticeNo" value="${requestScope.map.notice.getNoticeNo()}" />
						작성일: <c:out value="${requestScope.map.notice.getRegDate()}" />
					  </th>
					  </tr>                         
                   </thead>
                   
                    <tbody>
                                            	 
                        <tr >
                          <td>
                            <h3> 제목 </h3>   
                          </td>     
                        </tr>
                        <tr>   
                            <td>      
                                <textarea name="title" maxlength="30" style="resize: none; width:100%" rows="3" disabled='true'>  
                                <c:out value="${requestScope.map.notice.getSubject()}" />
                                </textarea>
                        	</td>                        											
                        </tr>
                        
                        <tr>                                                                               
                        	<td>
                        		<h3> 본문 </h3>
                            </td>		
                        </tr>
                        <tr>
                            <td>
              	 	  			<textarea name="content" maxlength="1000" placeholder="(1000자 입력제한)"  style="resize: none; width:100%" rows="20" disabled='true'>
              	 	  			<c:out value="${requestScope.map.notice.getContent()}" />
              	 	  			</textarea>
           					</td>	
                        </tr>
                        
                    </tbody> 
                    
                    <tfoot>
                            <tr>
                        	 <td>
                        	    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
								<button class="btn btn-primary" type="button" onclick="backward();">돌아가기 </button> 
                        	     <button class="btn btn-success" type="button" onclick="refresh();" style="float: left;">새로고침</button>
                        	     </div>                                	                        	          
                            </td>
                            <td> 
                            
								<div class="d-grid gap-2 d-md-flex justify-content-md-end">																																				 
						  		  <button class="btn btn-warning me-md-2" type="button" onclick="return updateNotice();" id="update">수정</button>
								  <button class="btn btn-outline-danger" type="button" onclick="deleteNotice();">삭제</button>	  		  
								</div>
                            
				            </td>														
                        </tr>
                    </tfoot>    
                                     
                 </table> 
                </div>                	         	                 
                
            </div>

               
         </div>
	          
 </div>       

   <script>
        $("tr>td").click(function(){
            $(this).parent().next().children().children().focus();
        });       
   </script>
   
      <script>
   	function refresh(){
		location.reload();
	}
    </script>
    
    <script>
	function backward(){
		var back = ${requestScope.map.currentPage}
		location.href="/admin/noticeManage.do?currentPage="+back; 		
	}
	</script>
	
	<script>
	function updateNotice(){		
		var text = $('#update').text();		
		
		if ( text == '수정'){			
			$('#update').text('완료');
			$('textarea[name=content]').prop('disabled',false);
			$('textarea[name=title]').prop('disabled',false);
			
		}else if(text=='완료'){
			var content = $('textarea[name=content]').val();
			var title = $('textarea[name=title]').val();
			var noticeNo = $('input[name=noticeNo]').val();						
			console.log(content);
			console.log(title);
			console.log(noticeNo);
			
			 if (content.length == 0 || title.length == 0){
				 alert('제목/내용을 입력해야 합니다');
				 return false;
			 }else{			
			$.ajax({
		    	url : "/admin/updateNotice.do",
		        type : "post",            
		        data : {"content":content, "title":title, "noticeNo":noticeNo },
		        
		        success : function(data) {           
		      if (data == 'true')	{            	
		          alert('수정 완료');
		          location.replace("/admin/noticeManage.do");
		        }else{
		        	alert('수정 실패');
					$('textarea[name=content]').prop('disabled',true);
					$('textarea[name=title]').prop('disabled',true);
		         }			        
		        },
		        error : function(data) {
		            alert("ajax error");
		        }
		    	})
			}
		}	
	}	
	</script>
    
    <script>
	function deleteNotice(){
		var noticeNo = $('input[name=noticeNo]').val();				
		if ( window.confirm('조회중인 공지사항을 삭제합니다')){
			
			$.ajax({
		    	url : "/admin/noticeDelete.do",
		        type : "post",            
		        data : {"noticeNo":noticeNo},
		        
		        success : function(data) {           
		      if (data == 'true')	{            	
		          alert('삭제 완료');
		          location.replace("/admin/noticeManage.do");
		        }else{
		        	alert('삭제 실패');
		         }			        
		        },
		        error : function(data) {
		            alert("ajax error");
		        }
		    })		
		}else{
			return false;
		}		
	}
</script>
    
</body>
</html>