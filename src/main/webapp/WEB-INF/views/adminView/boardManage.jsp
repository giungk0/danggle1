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
<link rel="stylesheet" type="text/css" href="/resources/css/boardManage.css">
</head> 
          
<body>
   
   <div class="wrap"> 
   	
      <div id="header">  <%@ include file="/WEB-INF/views/adminView/adminHeader.jsp" %> </div>
       
       <div id="body">
          
         <div id="aside">  <%@ include file="/WEB-INF/views/adminView/adminAside.jsp" %>  </div>
           
         <div class="contents">
            
            <div class="search">
              <form action="/admin/boardSearch.do" method="get">	
                <select name="tag"> 
                    <option disabled selected>검색</option>
                    <option value="subject">제목</option>
                    <option value="content">내용</option>
                    <option value="all">제목+내용</option>
                </select>
                <input type="hidden" name="currentPage" value="${requestScope.map.currentPage}" />
                <input type="text" name="keyword">
                <input type="submit" value="검색">                
              </form> 
            </div>
            
        	<div class="table">
                <table class="table table-hover" >        	 
                    <thead>
                        <tr style="text-align:center;">
                            <th>게시물 번호</th>                            
                            <th>게시물 제목</th>
                            <th>글 작성일</th>
                            <th>작성자(회원번호)</th>
                            <th>조회수</th>
                            <th>삭제 여부</th>                            
                            <th>선택</th>                            
                        </tr>
                    </thead>
                    <tbody>
                   <c:choose>
                   
                   	<c:when test="${requestScope.map.list != null}">
                   		
                    		<c:forEach var="n" items="${requestScope.map.list}">
                        		<tr>
                            		<td> <c:out value="${n.getBoardNo()}" /> </td>
                            		
                            		<td>
                            			<c:url var="url" value="/board/selectContent.do" >											
											<c:param name="boardNo"> ${n.getBoardNo() } </c:param>
										</c:url>
										
									<a href= "${url}" style="text-decoration:none;" target=”_blank”> <c:out value="${n.getSubject()}" /> </a>
									</td>
										                        		                                                   
                            		<td> <c:out value="${n.getRegDate()}" /> </td>
                            		<td> <c:out value="${n.getMemberNo()}" /> </td>
                            		<td> <c:out value="${n.getViewCount()}" /> </td>
                            		<td> <c:out value="${n.getDelYN()}" /> </td>
                            		<td> <input type="checkbox" value="${n.boardNo}"> </td>
                        		</tr>
                        	</c:forEach>
                      
                    </c:when>
                    
                    	<c:otherwise>
                    		<tr> <td colspan="6"> 검색된 내용이 없습니다 </td>  </tr>
                    	</c:otherwise>
                    	
                   </c:choose>                                              
                    </tbody>
                    <tfoot style="text-align: center;">                            
                    
                     <c:choose>
                      <c:when test="${requestScope.map.pageNavi != null}">                      		
                      	  <tr>                        	   
                           	   <td></td>
                           	   <td></td>                           	   
                           	   <td colspan="3">
									  <ul class="pagination">
								  			<li class="page-item"><a class="page-link" href="/admin/noticeManage.do?currentPage=${requestScope.map.start}">처음</a></li>
      										 ${requestScope.map.pageNavi}
									    	<li class="page-item"><a class="page-link" href="/admin/noticeManage.do?currentPage=${requestScope.map.end}">끝</a> </li>									    
 								  	</ul>						    
                           		</td>                             		                   		
                        	</tr>                                                        
                       </c:when>
                       
						<c:otherwise>
                      	  <tr>
                           	   <td colspan="3"> </td>
                           	   <td colspan="3">
									  <ul class="pagination">
								  			<li class="page-item"><a class="page-link" href="">처음</a></li>
    									  									
    										<li class="page-item">
      											<a class="page-link" href=""> 페이징 없음 </a>
									    	</li>
									    
									    	<li class="page-item"><a class="page-link" href="">끝</a> </li>									    
 								  	</ul>
                           		</td>
                           		<td></td>
                        	</tr>                    	
                    	</c:otherwise>                                              
                       </c:choose>    
                                                   
                        <tr>
                            <td colspan="5"> 
                            	<button type="button" class="btn btn-success" onclick="pageRefresh();" style="float:left;">
                            		새로고침	
                            	</button>
                            </td>
                            
                             <td> 
                            	<button type="button" class="btn btn-secondary" onclick="allSelect();">
                            		전체선택	
                            	</button>
                            </td>
                            
                            <td>                                    
                                <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#gradeForm" onclick="printData();">
                                 	 변경
                                </button>
                                
                                <div class="modal fade" id="gradeForm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                  <div class="modal-dialog modal-sm">
                                    <div class="modal-content">                                     
                                          <div class="modal-body">
                                            <br>
                                            	변경할 대상: <span id="selectMsg"> </span> 
                                            <br>	
                                              <select id="gradeValue"> 
                                                <option disabled selected> 상태 변경 </option>
                                                                                                                                                                                        
                                                <option value="Y">삭제(Y)</option>
                                                <option value="N">게시(N)</option>
                                              </select>                                                                                            
                                              
                                          </div>
                                      <div class="modal-footer">
                                      <button type="button" class="btn btn-outline-danger" onclick="statusChange();">실행</button>
                                      <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">닫기</button>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                            
                            </td>
                        </tr>                        
                    </tfoot>
                  </table>
             </div>   
               
           </div>
           
       </div>
       
       
   <script>
   		$('button[type=submit]').click(function(){   			 			
   			$('select > option:disabled').removeAttr("disabled")   			
   		});   
   </script>

	<script>
		function printData(){		
			var dataArray = new Array();				
			$('input:checked').each(function(){
				dataArray.push( this.value );
			});
			if (dataArray != 0){
				$('#selectMsg').text(dataArray);
			}else{
				$('#selectMsg').text('선택된 대상이 없음');	
			}
	}	
	</script>
	
   <script>
		function statusChange(){
			var dataArray = new Array();
			var status = $('#gradeValue>option:selected').val();
			
			$('input:checked').each(function(){
				dataArray.push( this.value );
			})
			
			if( dataArray == 0 ){
				return false;
			}else{					
				$.ajax({
			    	url : "/admin/boardChange.do",
			        type : "post",            
			        data : {"dataArray":dataArray,"status":status},			        
			        success : function(data) {           
			      if (data == 'pass') {            				          
			    	 alert('변경 성공');
			    	  $('#gradeForm').modal('hide');
			          location.reload();
			        }else{
			          $('#selectMsg').text('변경 실패');			        				     
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
   		
        $("tbody>tr").click(function(){        	           
        	var $test = $(this).children().eq(6);        	        	

        	if ($test.children().prop('checked') == true) {
        		$test.children().prop('checked',false);
        		$test.parent().removeAttr("style");
        	}else{
        		$test.children().prop('checked',true);        		
        		$test.parent().css('background','grey');
        	}
        });       
   </script> 
   
   <script>
   		function pageRefresh(){
   			location.replace("/admin/boardManage.do");
   		};
   </script>
   
   <script>
   		function allSelect(){
   			if ($('input[type=checkbox]').prop('checked') == false ){
   				$('input[type=checkbox]').prop('checked',true);	
   				$('input[type=checkbox]').prop('checked',true).parent().parent().css('background','grey');
   				
   			}else{   				
   				$('input[type=checkbox]').prop('checked',false);
   				$('input[type=checkbox]').prop('checked',false).parent().parent().removeAttr("style");
   			}   			
   		}
   </script>
   
</body>
</html>