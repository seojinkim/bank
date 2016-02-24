<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
   <div id="login" align="center">
      <div class="loginTop">
         <h2>
            <p>LOGIN</p>
            <span>로그인</span>
         </h2>
      </div>
      <div class="loginCenter" style="width: 20%;">
         <form action="${context}/member/login" method="get" name="loginForm">
            <fieldset class="loginField">
               <div class="form-group">
                  <span class="input_box"> <input type="text" class="form-control" name="userid" id="userid"
                     placeholder="아이디" maxlength="20" />
                  </span>
               </div>
               <div class="form-group">
                  <span class="input_box"> <input type="password" class="form-control" 
                     name="password" id="password" placeholder="비밀번호" maxlength="20" />
                  </span>
               </div>
               <div class="input_button">
                  <span class="input_box"> <input type="button" class="btn btn-default" 
                     id="loginButton" value="로그인" onclick="login()" />
                  </span>
               </div>
            </fieldset>
            <div>
               <br>
               <div>아이디가 없다면 회원가입 바랍니다.</div>
               <a href="${context}/member/joinForm">회원가입 바로가기</a>
            </div>
         </form>
      </div>
   </div>
   <script type="text/javascript">
      function login() {
         alert("로그인 버튼 클릭!!");
         if(document.loginForm.userid.value == ''){
            alert("아이디를 입력해 주세요");
         }else if(document.loginForm.password.value == ''){
            alert("비밀번호를 입력해 주세요");
         }else{
            document.loginForm.submit();
            return true;
         }         
      }
   </script>
</body>
</html>