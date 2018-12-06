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
<script type="text/javascript" src="resources/js/newsinfo.js"></script>
</head>
<body>
<form id="searchform">
	<label>输入新闻标题</label><input class="easyui-textbox" name="title1">

	<a href="javascript:void(0)" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
	<a href="views/AddNews.jsp" class="easyui-linkbutton"  data-options="iconCls:'icon-add'">新增</a>
	<a href="javascript:void(0)" id="deleteBtn" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a>
	<a href="javascript:void(0)" name="update" id="updateBtn" class="easyui-linkbutton" data-options="iconCls:'icon-update'">详情</a>
	<div style="margin:20px 0;"></div>
	
	
			<table id="newsTable" class="easyui-datagrid" url="newsServlet?cmd=queryNews" style="width:100%;height:auto">
		<thead>
			<tr>
				<th data-options="field:'newsid',width:60,align:'center'">序号</th>
				<th data-options="field:'title',width:150,align:'center'">标题</th>
				<th data-options="field:'releaseDate',width:150,align:'center'">时间</th>
				<th data-options="field:'newsAbstract',width:300,align:'center'">摘要</th>
				<th data-options="field:'text',width:300,align:'center'">内容</th>				
			</tr>	
		</thead>
	</table>
	</form>	
	<!-- 修改的弹出框 -->
	<div id="updateWindow" class="easyui-window" title="Modal Window" 
		data-options="modal:true,closed:true,iconCls:'icon-save'" 
		style="width:50%;height:300px;padding:10px;">
		<form id="updateform" style="text-align: center;">
			<input name="userId" id="userId" type="hidden">
			<table style="display: inline-block;">
				<tr>
					<td><label>序号:</label> </td>
					<td><input readonly="readonly" class="easyui-textbox" id="newsid" name="newsid"> </td>
					<td><label>标题:</label> </td>
					<td><input class="easyui-textbox" id="title" name="title"> </td>
					
					
				</tr>
				<tr>
					<td><label>摘要:</label> </td>
					<td><input class="easyui-textbox"  name="newsAbstract"> </td>
					<td><label>内容:</label></td>
					<td><input class="easyui-textbox" name="text"></td>
				</tr>
			</table>
			<br/>
			<a href="javascript:void(0)" id="saveUpdateBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
		</form>
	</div>
	
</body>
</html>