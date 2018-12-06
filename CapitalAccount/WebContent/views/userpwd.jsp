<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath }/">
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui-1.6.10/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="resources/jquery-easyui-1.6.10/themes/bootstrap/easyui.css">
<script type="text/javascript" src="resources/js/userpwd.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	
	<div style="margin:20px 0;"></div>
	<div style="margin-left: auto;margin-right:auto; width: 400px;margin-top: 50px">
	<div class="easyui-panel" title="修改密码" style="width:400px;" >
		<div style="padding:10px 60px 20px 60px;">
		
	    <form id="updatepwd">
	    	<table cellpadding="5" id="pwdTable">
	    	        
	    		<tr>
	    			<td>当前密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="nowpwd" data-options="required:true,prompt:'请输入当前密码',width:'200px'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新的密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="newpwd" data-options="required:true,prompt:'请输入新的密码',width:'200px'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>确认密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="confirmpwd" data-options="required:true,prompt:'请确认密码',width:'200px'"></input></td>
	    		</tr>
	    		
	    		</table>
	    		<br/>
	    		
	    	<a href="javascript:void(0)" id="saveUpdateBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			<a href="javascript:void(0)" id="canceUpdatelBtn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	            
	    </form>
	      
	    </div>
	     </div>
	</div>

</body>
</html>