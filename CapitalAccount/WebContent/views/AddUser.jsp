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
				<tr> 
					<td class="name1"><label>账    户:</label></td>
					<td><input class="easyui-textbox name2" name="accountid" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>密    码:</label></td>
					<td><input class="easyui-textbox name2" name="password" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>确认密码:</label></td>
					<td><input class="easyui-textbox name2" name="passwordNew" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>开户金额:</label></td>
					<td><input class="easyui-textbox name2" name="balance"></td>
				</tr>
				<tr> 
					<td class="name1"><label>用户个人信息编号:</label></td>
					<td><input class="easyui-textbox name2" name="personid" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>姓    名:</label></td>
					<td><input class="easyui-textbox name2" name="realname" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>出生日期:</label></td>
					<td><input id="birthday" name="birthday" type="text" class="easyui-datebox name2" required="required"></td>
				</tr>
				<tr> 
					<td class="name1"><label>性    别:</label></td>
					<td><select class="easyui-combobox name2" name="sex" style="width:60px">
												<option>男</option>
												<option>女</option>
												</select></td>
				</tr>
				<tr> 
					<td class="name1"><label>家庭地址:</label></td>
					<td><input class="easyui-textbox name2" name="address" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>电话号码:</label></td>
					<td><input class="easyui-textbox name2" name="telephone" required></td>
				</tr>
				<tr> 
					<td class="name1"><label>身份证号:</label></td>
					<td><input class="easyui-textbox name2" name="cardid" required></td>			
				</tr>				
			</table>
			<br/>			
			<a href="javascript:void(0)" id="addUserSaveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>
			<a href="javascript:void(0)" id="addUserCancelBtn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
		</form>
	</div>
</body>
</html>