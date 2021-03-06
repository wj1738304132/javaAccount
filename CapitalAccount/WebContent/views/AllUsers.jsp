<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>主页</title>
</head>
<body>
	<div style="height: 30px;background-color: #E1E1E1">
		
	</div>
	<div class="search" >
		<form id="searchForm">
			<div style="margin-left: auto;margin-right: auto;">
				<label >输入姓名查询</label><input class="easyui-textbox" name="realName">
				<a href="javascript:void(0)" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				<a href="javascript:void(0)" id="frozenBtn" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">冻结</a>
				<a href="javascript:void(0)" id="enableBtn" class="easyui-linkbutton" data-options="iconCls:'icon-update'">启用</a>
				<a href="javascript:void(0)" id="deleteBtn" class="easyui-linkbutton" data-options="iconCls:'icon-update'">删除</a>
				<a href="javascript:void(0)" id="queryBtn" class="easyui-linkbutton" data-options="iconCls:'icon-update'">查看个人信息</a>
			</div>
		</form>
	</div>
	<div>
		<table id="allUser" class="easyui-datagrid" url="adminServlet?cmd=queryUser" style="width:100%;">
			<thead data-options="frozen:true">
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',width:50,align:'center',formatter:myformat">序号</th>
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
		<div id="AllUserPage" class="easyui-pagination" align="center" style="background:#efefef;border:1px solid #ccc;">
		 	
		</div>
	</div>
	<!-- 添加的弹出框 -->
	<div id="QueryInfo" class="easyui-window" title="Modal Window" 
		data-options="modal:true,closed:true,iconCls:'icon-save'" 
		style="width:100%;height:300px;padding:10px;">
		<form id="queryform" style="text-align: center;">
			<table id="queryInfo" class="easyui-datagrid" style="width:100%;height:250px">
				<thead data-options="frozen:true">
					<tr>
						<th data-options="field:'id',width:30,align:'center'" id="rowsNum">序号</th>
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
		</form>
	</div>
</body>
</html>