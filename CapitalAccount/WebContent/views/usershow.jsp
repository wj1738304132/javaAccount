<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<base href="${pageContext.request.contextPath }/">
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/icon.css">
<script type="text/javascript" src="resources/js/userinfo.js"></script>

</head>
<body>
    <div>查看个人信息</div>
    <div>
		<table id="userTable" class="easyui-datagrid" url="userShow?cmd=queryUser" style="width:100%;height:auto">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'realname',width:100">姓名</th>
					<th data-options="field:'birthday',width:100">出生日期</th>
					<th data-options="field:'sex',width:80,align:'right'">用户性别</th>
					<th data-options="field:'address',width:80,align:'right'">家庭住址</th>
					<th data-options="field:'telephone',width:250">手机号码</th>
					<th data-options="field:'cardid',width:250">身份证号码</th>
				</tr>
			</thead>
		</table>
	</div>

</body>
</html>