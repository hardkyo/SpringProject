<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${root }/css/style.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#loginBtn').click(function(){
		if ($('#id').val()=="") {
			alert("아이디입력");
			return
		} else if ($('#pass').val()=="") {
			alert("비밀번호 입력")
			return
		} else {
			$('form[name=loginform]').attr('action','${root}/user/login.kitri');
	        $('form[name=loginform]').submit();
		}
	})
	
	$('#registerBtn').click(function(){
		$(location).attr('href', '${root}/user/register.kitri');
	})
});

	
	
/* function logincheck(){
	if(document.getElementById("id").value  == "") {
		alert("아이디 입력!");
		return;
	} else if(document.getElementById("pass").value == "") {
		alert("비밀번호 입력!");
		return;
	} else {
		document.loginform.action = "";
		document.loginform.submit();
	}
} */

</script>
</head>
<body>
<center>
<form name="loginform" method="post" action="">
<table>
<tr>
	<td class="td1">아이디</td>
	<td class="td3"><input type="text" name="id" id="id"></td>
</tr>
<tr>
	<td class="td2">비밀번호</td>
	<td class="td4"><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" id="loginBtn" value="로그인">
	<input type="button" id="registerBtn" value="회원가입">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>