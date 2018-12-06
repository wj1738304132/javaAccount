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
	<form id="addform">
		<table border="1" cellpadding="10" cellspacing="0" >
		<tr>
		<td bgcolor="grey" width="300" height="100" align="center">标题</td>
		<td width="500"><input type="text" maxlength = "15"name="title"style="width:350px">*15字以内</td>
		</tr>
		<tr>
		<td bgcolor="grey" width="300" height="100" align="center">摘要</td>
		<td width="500"><textarea maxlength = "50" name="newsAbstract" style="width:380px; height:50px" warp="virtual"></textarea>*50字以内</td>
		</tr>
		<tr>
		<td bgcolor="grey" width="100" height="350" align="center">正文</td>
		<td><textarea maxlength = "500" name="text" style="width:380px; height:300px" warp="virtual"></textarea>*500字以内</td>
		
		</tr>
		</table>
	
		<a href="javascript:void(0)" id="addBtn" class="easyui-linkbutton"   data-options="iconCls:'icon-add'">提交</a>
		</form>
		
	</body>
</html>