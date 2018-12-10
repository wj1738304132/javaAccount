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
<script type="text/javascript" src="resources/js/adminInfo1.js"></script>
<title>冻结用户界面</title>
</head>
<body>
	<div style="height: 30px;background-color: #E1E1E1">
		
	</div>
	<div class="search" >
		<form id="searchForm">
			<div style="margin-left: auto;margin-right: auto;">
				<label >输入姓名查询</label><input class="easyui-textbox" name="realName">
				<a href="javascript:void(0)" id="searchFrozenBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				<a href="javascript:void(0)" id="enableBtn" class="easyui-linkbutton" data-options="iconCls:'icon-update'">启用</a>
			</div>
		</form>
	</div>
	<div>
		<table id="allUser" class="easyui-datagrid" style="width:100%;height:250px">
			<thead data-options="frozen:true">
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',width:30,align:'center',formatter:myformat">序号</th>
					<th data-options="field:'accountid',width:100,align:'center'">账户</th>
					<th data-options="field:'balance',width:150,align:'center'">账户余额</th>
					<th data-options="field:'realname',width:80,align:'center'">姓名</th>
					<th data-options="field:'address',width:300,align:'center'">详细地址</th>
					<th data-options="field:'cardid',width:150,align:'center'">身份证号</th>
					<th data-options="field:'telephone',width:100,align:'center'">电话</th>
					<th data-options="field:'name',width:80,align:'center'">状态</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>