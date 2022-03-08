<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/mainIndex.css">
</head>

<body>


<body style="background-color: #FAFBFE;">
   
    <div id="wrap">
        <div id="header"> <%@ include file="/WEB-INF/views/mainPageView/mainHeader.jsp" %> </div>
        
             <div id="carouselBox">
                      
                      <div id="prev">  &lt; </div>                        
                    <div>
                        <div class="slideItem show"> <img src="/resources/images/carousel4.jpg">  </div>
                         
                        <div class="slideItem"> <img src="/resources/images/carousel3.jpg"> </div>
                         
                        <div class="slideItem"> <img src="/resources/images/carousel1.jpg"> </div>
                        
                        <div class="slideItem"> <img src="/resources/images/carousel2.jpeg"> </div>                  
                    </div>                          
                       <div id="next">  &gt; </div>
                       
             </div>
              
             <div id="contentsBox">
                 
                 <div id="diaryBox">
                     <div id="diaryTitle"> 
                         <p> 다이어리 <p>
                         <p> 소중한 반려견의 하루하루를 기록하세요 </p>
                     </div>
                     
                     <div id="diaryContent">
                         <h2>다이어리</h2>                      
                     </div>
                     
                 </div>
                 
                 <div id="areaBox">
                     <div id="areaTitle">
                         <p> 멍세권 <p>
                         <p style="font-size: 21px;"> 우리 강아지의 베스트 프렌드부터 자격 있는 펫시터까지! </p>                         
                     </div>
                      
                  <c:forEach var="n" items="${requestScope.dlist}">                                             
                     <div class="row1">                      
                        <div class="petPic"> 
                            			<c:url var="url" value="/myPage/diaryPage.do" >
											<c:param name="currentPage"> 1 </c:param>
											<c:param name="memberNo"> ${n.getMemberNo() } </c:param>
										</c:url>										
									<a href= "${url}" target=”_blank”> <img style="object-fit:cover; width:100%; height:100%;" src="/resources/upload/dogProfile/<c:out value="${n.getDogProfile()}"/>"> 
									</a>
                        </div>
                        <div class="petProfile"> 
                           
                            <table>                            	
                                <tr>
                                    <td> 이름 </td>    
                                    <td> <span> <c:out value="${n.getDogName()}" /> </span> </td>                                    
                                </tr>
                                
                                <tr>
                                    <td> 성별 </td>    
                                    <td> <span> <c:out value="${n.getGender()}" /> </span> </td>
                                </tr>
                                
                                <tr>
                                    <td> 생일 </td>    
                                    <td> <span> <c:out value="${n.getBirthdate()}" />  </span> </td>
                                </tr>
                                
                                <tr>
                                    <td> 품종 </td>    
                                    <td> <span> <c:out value="${n.getBreed()}" /> </span> </td>
                                </tr>
                                
                                <tr>
                                    <td> 사이즈 </td>    
                                    <td> <span> <c:out value="${n.getDogSize()}" /> </span> </td>
                                </tr>
                                
                                <tr>
                                    <td> 접종유무 </td>    
                                    <td> <span> <c:out value="${n.getVaccinationYN()}" /> </span> </td>
                                </tr>
                                
                                <tr>
                                    <td> 중성화유무 </td>    
                                    <td> <span>  <c:out value="${n.getNeutralizationYN()}" /> </span> </td>
                                </tr>
                                
                            </table>                                                     
                        </div>                                                                      
                     </div>                          
                     </c:forEach>
                                                                 
                   </div>                                             

                 <div id="communityBox">
                 
                       <div id="communityTitle">
                           <p>커뮤니티</p>
                           <p>우리 강아지에게 유익한 정보 가득!</p>
                       </div>
                       
                       <div class="comBox1"> 
                       	<div> 
		           			<c:url var="url" value="/board/selectContent.do" >											
							<c:param name="boardNo"> ${requestScope.list[0].boardNo } </c:param>
							</c:url>										
		 					<a href= "${url}" style="text-decoration:none;" target=”_blank”> 
                       		<h4> ${requestScope.list[0].subject} </h4> 
                       		</a>
                       	</div> 
                       		<p> ${requestScope.list[0].content} </p>                         	
                       	</div>
                       	
                       <div class="comBox2"> 
                        <div> 
		           			<c:url var="url" value="/board/selectContent.do" >											
							<c:param name="boardNo"> ${requestScope.list[1].boardNo } </c:param>
							</c:url>										
		 					<a href= "${url}" style="text-decoration:none;" target=”_blank”>
                        	 <h4> ${requestScope.list[1].subject} </h4>                     
                        	 </a>    
                        </div> 
                        	  <p> ${requestScope.list[1].content} </p> 
                        </div>
                        
                       <div class="comBox3"> 
                         <div> 
		           			<c:url var="url" value="/board/selectContent.do" >											
							<c:param name="boardNo"> ${requestScope.list[2].boardNo } </c:param>
							</c:url>										
		 					<a href= "${url}" style="text-decoration:none;" target=”_blank”>
                         	<h4> ${requestScope.list[2].subject} </h4>
                         	</a> 
                         </div> 
                         	<p> ${requestScope.list[2].content} </p> 
                       </div>
                                                
                </div>                                                                                                                                                                                                          
             </div> 
             
                     <div id="footer"> <%@ include file="/WEB-INF/views/mainPageView/mainFooter.jsp" %> </div>                                             
    </div>
          
<script>
    
const firstSlide = document.querySelector('.slideItem:first-child');
const lastSlide = document.querySelector('.slideItem:last-child');
    
document.getElementById('next').addEventListener('click', prevSlide);
document.getElementById('prev').addEventListener('click', nextSlide);

function nextSlide() {
  const currentSlide = document.querySelector('.show');
  if(currentSlide) {
    currentSlide.classList.remove('show');
    const nextSlide = currentSlide.nextElementSibling;

    if(nextSlide) {
      nextSlide.classList.add('show');
    } else {
      firstSlide.classList.add('show');
    }
  } else {
    firstSlide.classList.add('show');
  }
}


function prevSlide() { 
  const currentSlide = document.querySelector('.show');
  if(currentSlide) {
    currentSlide.classList.remove('show');
    const prevSlide = currentSlide.previousElementSibling;
    
    if(prevSlide) {
      prevSlide.classList.add('show');
    } else {
      lastSlide.classList.add('show');
    }
  } else {
    lastSlide.classList.add('show');
  }
}
</script>
    
    
    
   <script>
       $('#diaryContent').click(function(){
           alert('다이어리 이동');
        });
              
   </script>
    

</body>
</html>