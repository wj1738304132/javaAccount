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
<link rel="stylesheet" href="resources/css/AddUser.css">
<script type="text/javascript" src="resources/js/adminInfo.js"></script>
<title>开户界面</title>
</head>
<body>
	<div id="addUser" align="center">
		<form id="addform" style="text-align: center;">
			<table style="display: inline-block;">
				<td> 
					<tr><label class="name1">账户:</label><input class="easyui-textbox" name="accountid" required></tr><br/>
					<tr><label class="name1">密码:</label><input class="easyui-textbox" name="password" required></tr><br/>
					<tr><label class="name1">确认密码:</label><input class="easyui-textbox" name="passwordNew" required></tr><br/>
					<tr><label class="name1">开户金额:</label><input class="easyui-textbox" name="balance"></tr><br/>
					<tr><label class="name1">用户个人信息编号:</label><input class="easyui-textbox" name="personid" required></tr><br/>
					<tr><label class="name1">姓名:</label><input class="easyui-textbox" name="realname" required></tr><br/>
					<tr><label class="name1">出生日期:</label><input id="birthday" name="birthday" type="text" class="easyui-datebox" required="required"><br/>
					<tr><label class="name1">性别:</label><select class="easyui-combobox" name="sex" style="width:60px">
												<option>男</option>
												<option>女</option>
												</select>
					</tr><br/>
					<tr><label class="name1">家庭地址:</label><input class="easyui-textbox" name="address" required></tr><br/>
					<tr><label class="name1">电话号码:</label><input class="easyui-textbox" name="telephone" required></tr><br/>
					<tr><label class="name1">身份证号:</label><input class="easyui-textbox" name="cardid" required></tr><br/>
				</td>
				
			</table>
			<br/>			
			<a href="javascript:void(0)" id="addUserSaveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>
			<a href="javascript:void(0)" id="addUserCancelBtn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
		</form>
	</div>
</body>
</html>