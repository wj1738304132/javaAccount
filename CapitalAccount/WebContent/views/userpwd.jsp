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
<script type="text/javascript" src="resources/js/userpwd.js"></script>



</head>
<body>
    <div>修改密码</div>
    <form id="ff" method="post">
    <div>
		<label for="">当前密码:</label>
		<input class="easyui-validatebox" type="text" name="nowpwd" data-options="required:true" />
    </div>
    <div>
		<label for="email">新的密码:</label>
		<input class="easyui-validatebox" type="text" name="newpwd" data-options="validType:'email'" />
    </div>
    <div>
		<label for="email">确认密码:</label>
		<input class="easyui-validatebox" type="text" name="confirmpwd" data-options="validType:'email'" />
    </div>
    <div></div>
</body>
</html>