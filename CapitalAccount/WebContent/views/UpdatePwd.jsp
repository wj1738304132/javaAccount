<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath }/">
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/icon.css">
<script type="text/javascript" src="resources/js/adminInfo.js"></script>
<title>修改密码界面</title>
</head>
<body>
	<div id="updatePwd" align="center">
		<form id="updateform" style="text-align: center;">
			<table style="display: inline-block;">
				<td>
					<tr><label class="pwd">当前密码:</label><input class="easyui-textbox" name="adminPasswordOld" required></tr><br/>
					<tr><label class="pwd">新的密码:</label><input class="easyui-textbox" name="adminPasswordNew1" required></tr><br/>
					<tr><label class="pwd">确认金额:</label><input class="easyui-textbox" name="adminPasswordNew2" required></tr><br/>
				</td>				
			</table>
			<br/>			
			<a href="javascript:void(0)" id="updatePwdSaveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">确认</a>
		</form>
	</div>
</body>
</html>