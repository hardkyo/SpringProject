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
			alert("���̵��Է�");
			return
		} else if ($('#pass').val()=="") {
			alert("��й�ȣ �Է�")
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
		alert("���̵� �Է�!");
		return;
	} else if(document.getElementById("pass").value == "") {
		alert("��й�ȣ �Է�!");
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
	<td class="td1">���̵�</td>
	<td class="td3"><input type="text" name="id" id="id"></td>
</tr>
<tr>
	<td class="td2">��й�ȣ</td>
	<td class="td4"><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="button" id="loginBtn" value="�α���">
	<input type="button" id="registerBtn" value="ȸ������">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>