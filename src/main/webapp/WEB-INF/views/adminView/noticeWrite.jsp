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
<link rel="stylesheet" type="text/css" href="/resources/css/noticeWrite.css">
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
                      <th> <H2 > 공지사항을 작성합니다 </H2> </th>
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
                                <textarea name="title" maxlength="30" style="resize: none; width:100%" rows="1" > </textarea>
                        	</td>                        											
                        </tr>
                        
                        <tr>                                                                               
                        	<td>
                        		<h3> 본문 </h3>
                            </td>		
                        </tr>
                        <tr>
                            <td>
              	 	  			<textarea name="content" maxlength="1000" placeholder="(1000자 입력제한)"  style="resize: none; width:100%" rows="20"> </textarea>
           					</td>	
                        </tr>                        
                    </tbody> 
                    
                    <tfoot>
                            <tr>
                        	 <td> 
                        	     <button class="btn btn-secondary" type="button" onclick="refresh();" style="float: left;">새로고침</button>                                	                        	          
                            </td>
                            <td> 
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">              
								  <button class="btn btn-outline-warning me-md-2" type="submit" style="float: left;">작성</button>									  	  
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
   		$('button[type=submit]').click(function(){
   			var inputNotice = $('textarea').val();   			
   			if( inputNotice.replace(/\s| /gi, "").length == 0 ) {
   				alert('제목/본문을 입력해야 합니다');
   				return false;
   			}else{
   				var content = $('textarea[name=content]').val();
   				var title = $('textarea[name=title]').val();
   				$.ajax({
   			    	url : "/admin/insertNotice.do",
   			        type : "get",            
   			        data : {"content":content, "title":title},
   			        
   			        success : function(data) {           
   			      if (data == "true")	{            	
   			          alert('작성 완료');
   			          location.replace("/admin/noticeManage.do");
   			        }else{
   			        	alert('작성 실패');   						
   			         }			        
   			        },
   			        error : function(data) {
   			            alert("ajax error");
   			        }
   			    	})
   			}
   		});   
   </script>
   
   
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

</body>
</html>