<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>

    <style>
        * {
            box-sizing: border-box;
			font-family: 'Noto Sans KR', sans-serif;
            font-size: 15px;
            font-weight: bold;
            color: #919CA7;
        }

        .wrap {
            width: 480px;
            height: 280px;
            margin: 0 auto;
        }

        .content {
            width: 350px;
            height: 120px;
            margin: 0 auto;
            text-align: center;
            position: relative;
            top: 70px;
        }
        
        span{
            margin-right: 15px;
        }

        input[type=password] {
            width: 250px;
            height: 37px;
            border: 1px solid #919CA7;
            border-radius: 5px;
            padding: 0 8px 0 8px;
        }

        .pwd_change_btn {
            border: 1px solid #FD6F22;
            background-color: #FD6F22;
            color:#ffffff;
            width: 120px;
            height: 40px;
            border-radius: 5px;
            cursor: pointer;
            filter: drop-shadow(4px 4px 4px rgba(0, 0, 0, 0.10));

        }
    </style>

</head>
<body>

    <div class='wrap'>

        <div class='content'>
            <div>
            	<span>비밀번호</span> <input type='password' name='memberPwd' placeholder='비밀번호를 입력하세요.'>
            </div>
            <br>
            <div>
            	<button class="pwd_change_btn" onclick="checkPwd();">비밀번호 확인</button>
            </div>
        </div>

    </div>
    
    <script type="text/javascript">
    	const boardNo = ${ requestScope.boardNo };
    	function checkPwd() {
			var memberPwd= $('input[name=memberPwd]').val();
			$.ajax({
				url: "/board/updateCheck.do",
				data:{"memberPwd":memberPwd},
				type: "post",
				success: function (result) {
				
					if(result=='true'){
						var url="/board/updatePage.do?boardNo=" + boardNo;
						window.opener.location.href=url;
						window.close();
					}else{
						alert('비밀번호가 일치하지 않습니다.');
					}  
				},
				error: function () {
					console.log('ajax 통신 실패');
				}
			});
		}
    </script>
    

</body>
</html>











