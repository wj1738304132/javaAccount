<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<base href="${pageContext.request.contextPath }/">
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/icon.css">
<script type="text/javascript" src="resources/js/newsinfo.js"></script>
</head>
<body>
	<form id="updateform" name="update">
	<input name="userId" id="userId" type="hidden">
		<table style="display: inline-block;" border="1" cellpadding="10" cellspacing="0" name="update">
		
		<tr>
		<td bgcolor="grey" width="300" height="100" align="center">标题</td>
		<td width="500"><input type="text" id="title" maxlength = "15" name="title"style="width:350px" >*15字以内</td>
		</tr>
		<tr>
		<td bgcolor="grey" width="300" height="100" align="center">摘要</td>
		<td width="500"><input type="text" maxlength = "50" name="newsAbstract" style="width:380px; height:50px" warp="virtual" >*50字以内</td>
		</tr>
		<tr>
		<td bgcolor="grey" width="100" height="350" align="center">正文</td>
		<td><input class="easyui-textbox"  name="text" > </td>
		
		</tr>
		</table>
	
		<a href="javascript:void(0)" id="saveUpdateBtn" class="easyui-linkbutton"   data-options="iconCls:'icon-add'">提交</a>
		</form>
		
	</body>
</html>