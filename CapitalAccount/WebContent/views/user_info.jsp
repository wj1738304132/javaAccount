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
<div class="transaction">
<h1 style="align:'center'">交易记录</h1>
<form id="searchform">
<a href="javascript:void(0)" id="searchBtn" class="easyui-linkbutton" >查看</a>
</form>

    <table class="easyui-datagrid" id="userTable" style="width:700px;height:375px"  url="userServlet?cmd=queryUser"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
		<thead>

			<tr>
			    
				<th data-options="field:'transaction_id',width:60,align:'center'">交易序号</th>
				<th data-options="field:'otherid',width:150,align:'center'">对方账户</th>
				<th data-options="field:'money',width:150,align:'center'">交易金额</th>
				<th data-options="field:'typeid',width:170,align:'center'">交易类型</th>
				<th data-options="field:'datetime',width:167,align:'center'">交易日期</th>
								
			</tr>
			
		</thead>
     
		
	</table>

</div>
 
</body>
</html>