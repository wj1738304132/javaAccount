<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/">
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/icon.css">

<script type="text/javascript" src="resources/js/user_info.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="zhuanzhang">
<h1 style="align:'center'">转账</h1>
<form id="addform2">
    <label>交易类别：</label><select class="easyui-combobox" name="typeid" style="width:80px">
									<option value="">请选择</option>
									<option>存款</option>
									<option>取款</option>
									<option>转账</option>
								</select><br>
    <label>对方账户：</label><input type="text" name="otherid" ><br>
    
    <label>转账金额：</label><input type="text" name="money"><br>
    <button id="saveBtn2">提交</button>
    </form>
</div>
</body>
</html>