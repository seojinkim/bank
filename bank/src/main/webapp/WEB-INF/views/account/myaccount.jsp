<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style>
<!--
#tab{width:800px;height: 100px;border:1px solid black;border-collapse: collapse;}
#tab tr{width:800px;height: 50px;border:1px solid black;text-align: center;}
#tab tr td{border:1px solid black;text-align: center;}
.center{margin:0 auto;}
-->
</style>
</head>
<body>
	<h1>${id} 계좌정보 보기</h1>
	<div class="center"><a href="${context}/member/detail">마이페이지</a></div>
	<div >
		<!-- 테이블 만드는 단축키 : table>tr*2>td*4 -->
		<table id="tab" class="center">
			<tr>
				<td style="width:50px;">번호</td>
				<td style="width:400px;">계좌번호</td>
				<td style="width:150px;">비밀번호</td>
				<td style="width:200px;">잔액</td>
			</tr>
			<tr >
				<td style="width:50px;">${acc.seq}</td>
				<td style="width:150px;">${acc.accountNo}</td>
				<td style="width:200px;">${acc.password}</td>
				<td style="width:400px;">${acc.money}</td>
			</tr>
		</table>
	</div>
	
	
</body>
</html>

    
