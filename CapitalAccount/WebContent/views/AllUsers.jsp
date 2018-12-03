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
<title>Insert title here</title>
</head>
<body>
	<div style="height: 30px;background-color: #E1E1E1">
		
	</div>
	<div class="search" >
		<form id="searchForm">
			<div style="margin-left: auto;margin-right: auto;">
				<label >输入姓名查询</label><input class="easyui-textbox" name="userName">
				<a href="javascript:void(0)" id="searchBtn" data-options="iconCls:'icon-search'">查询</a>
			</div>
		</form>
	</div>
	<div>
		<table border="1px solid">
			<tr align="center">
				<th>序号</th>
				<th>账户</th>
				<th>账户余额</th>
				<th>姓名</th>
				<th>详细地址</th>
				<th>身份证号</th>
				<th>电话</th>
				<th>状态</th>
				<th>操作</th>
				<th>操作</th>
			</tr>
		<c:forEach items="${list}" var="user">
			<tr align="center">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>