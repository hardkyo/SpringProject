<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/css/style.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#searchBtn').click(function() {
		var sdong = $('#dong').val();
		if (sdong == "") {
			alert("동입력!!");
			return
		}else {
			$.ajax({
				type: "POST",
				dataType : 'json',
				url : '${root}/user/zipsearch.kitri',
				data : {'sdong' : sdong},
				success : function(data) {
					makeList(data);
				}
			})
		}
	});
	
	function makeList(data) {
		var output = '<table>';
		var zsize = data.ziplist.length;
		for (var i = 0; i < zsize; i++) {
			output += '<tr>';
			output += '	<td class = "address">';
			output += 	'<span class="zip1">' + data.ziplist[i].zip1 + '</span>-' ;
			output += 	'<span class="zip2">' + data.ziplist[i].zip2 + '</span>';
			output += 	'<span class="addr1">' + decodeURI(data.ziplist[i].address).replace('+', ' ') + '</span>';
			output += '	</td>';
			output += '</tr>';
		}
		output += '</table>'
		$('#zipresult').empty();
		$('#zipresult').append(output);
	}
	
	$(document).on('click', '.address', function(){
		//alert($(this).children('span').siblings().eq('0').text()); // 눌렀을 때의 자기자신을 >> this라 칭함
		opener.$('#zip1').val($(this).children('span').siblings().eq('0').text());
		opener.$('#zip2').val($(this).children('span').siblings().eq('1').text());
		opener.$('#addr1').val($(this).children('span').siblings().eq('2').text());
		self.close();
		// jqery로 retrun 받음 
	})
})
</script>
</head>
<body>
<center>
<form name="zipform" method="get" action="">
<input type="hidden" name="act" value="zipsearch">
<h3>우편번호검색</h3>
<table width="350">
<tr>
	<td class="td3">검색할동을 입력하세요<br>(예: 역삼동, 신촌)</td>
</tr>
<tr>
	<td class="td4">
	<input type="text" name="dong" id="dong">
	<input type="button" value="검색" id="searchBtn">
	</td>
</tr>
<tr>
	<td class="td4">
	<div id="zipresult"></div>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>










