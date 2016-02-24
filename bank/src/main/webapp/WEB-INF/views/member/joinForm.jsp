<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<div id="join">
		<div class="joinTop">
			<h2>
				<p>Sing Up</p>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="joinCenter">
			<form action="/member/join" method="get" name="joinForm">
				<fieldset class="joinField">
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="usrId" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="password" id="usrPw" placeholder="비밀번호"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="usrNm" placeholder="이름"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="usrBrth" placeholder="생일"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="usrAddr" placeholder="주소"/>
						</span>
					</div>
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="joinBtn" value="회원가입"/>
							<input type="button" id="cnclBtn" value="취소"/>
						</span>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>