<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    * {
        font-family: 'Noto Sans KR', sans-serif;
        color: #919CA7;
        font-weight: bold;
    }

    .wrap {
        width: 100%;
        margin: 0 auto;
        background-color: #FAFBFE;
        width: 1000px;
    }

    #writetitle {
        padding-top: 64px;
        padding-bottom: 35px;
        font-size: 25px;
        color: black;
        text-align: center;
    }

    #subject {
        border: 1px solid #D8D3D0;
        box-sizing: border-box;
        border-radius: 5px;
        height: 27px;
        width: 960px;
        margin-bottom: 10px;
        background-color: white;
    }

    #cancelBtn {
        background: #FD6F22;
        color: white;
        border-radius: 5px;
        height: 27px;
        border: 0px;
        outline: 0px;
        filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.10));
        float: right;
    }

    #writeBtn {
        border: 1px solid #FD6F22;
        background-color: white;
        box-sizing: border-box;
        border-radius: 5px;
        margin-left: 5px;
        width: 70px;
        height: 27px;
        filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.10));
        float: right;
    }


    .ck-editor__editable {
       height: 550px;
       width: 979px;
    }
    
     .image img{
        width: 300px;
        height: 300px;
    }
    
</style>

<!--에디터 api-->
<!-- <script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script> -->

<body>
<!--header(헤더)-->
<%@ include file="/WEB-INF/views/common/header.jsp"%>
    <div style="height: 105px;"></div>
    <div class="wrap" style="margin-bottom:200px;background-color: #FAFBFE;">
        <p id="writetitle">글 작성하기</p>
        
	<form id="form" action="/board/insertPost.do" method="post">
        제목 <input type="text" id="subject" name="subject"/>

        <textarea class="form-control" id="content" name="content"></textarea>

        <div class="container">
            <div class="content" style="width: 70%">

                <div class="row justify-content-md-center">
                    <div class="col_c" style="margin-bottom: 30px">
                        <div class="input-group">
                        </div>
                    </div>
                </div>


            </div>
            <input type = "submit" value="작성하기" id="writeBtn"/>
			
            <input type = "button" value="취소" id="cancelBtn"/>
        </div>
	</form>
    </div>
    
    
    <!-- footer(풋터) -->
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>
    
    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>

    <script>        

    
		        $(document).ready(function(){
		        	ClassicEditor
		            .create( document.querySelector( '#content' ), {
		                ckfinder: {
		                uploadUrl: '/board/communityFile.do'
		                }
		            })
		            .catch( error => {
		                console.error( error );
		            });
		        	

            
					$('#cancelBtn').on("click",function(){
						location.replace("/board/community.do");
					});

					
		        });
			</script>
</body>
</html>