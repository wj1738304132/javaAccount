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
<title>个人信息</title>
</head>
<body>
	<div>
		<table id="queryInfo" class="easyui-datagrid" style="width:100%;height:250px">
			<thead data-options="frozen:true">
				<tr>
					<th data-options="field:'id',width:150,align:'center'">账户</th>
					<th data-options="field:'id',width:50,align:'center'">账户状态</th>
					<th data-options="field:'accountid',width:100,align:'center'">账户余额</th>
					<th data-options="field:'balance',width:100,align:'center'">姓名</th>
					<th data-options="field:'realname',width:100,align:'center'">出生日期</th>
					<th data-options="field:'address',width:50,align:'center'">性别</th>
					<th data-options="field:'cardid',width:300,align:'center'">家庭地址</th>
					<th data-options="field:'telephone',width:200,align:'center'">手机号码</th>
					<th data-options="field:'name',width:300,align:'center'">身份证号</th>
				</tr>
			</thead>
		</table>
		<div id="AllUserPage" class="easyui-pagination" align="center">
		 
		</div>
	</div>
</body>
</html>