<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8" />
   <title>로그인</title>
</head>

<body>
	<div id="join">
		<div class="joinTop">
			<h2>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="joinCenter">
			<form action="${context}/member/join" method="post" name="joinForm">
				<fieldset class="joinField">
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="userid" name="userid" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="password" id="password" name="password" placeholder="비밀번호"/>
						</span>
					</div>
					
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="name" name="name" placeholder="이름"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="addr" name="addr" placeholder="주소"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="birth" name="birth" placeholder="생년월일"/>
						</span>
					</div>
					
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="joinButton" value ="회원가입" onclick="joinMember()"/>
						</span>
					</div>
					
				</fieldset>
			</form>
		</div>
	</div>
	<script type="text/javascript">

	function joinMember(){
		
		if (document.joinForm.userid.value=='') {
			alert('아이디를 입력해주세요');
			document.joinForm.userid.focus();
		} else if(document.joinForm.name.value=='') {
			alert('이름을 입력해주세요');
			document.joinForm.password.focus();
		} else if(document.joinForm.password.value=='') {
			alert('비밀번호를 입력해주세요');
			document.joinForm.password.focus();
		} else if(document.joinForm.addr.value=='') {
			alert('주소를 입력해주세요');
			document.joinForm.password.focus();
		} else if(document.joinForm.birth.value=='') {
			alert('생년원일을 입력해주세요');
			document.joinForm.password.focus();
		}else{
			document.joinForm.submit();
			return true;
		}
	}
	
	</script>
</body>
</html>