$(function(){
	
	$("#cancelUpdateBtn").click(function(){
		
	})
	$("#saveUpdateBtn").click(function(){
		
		$.ajax({
			url:"pwdUpdate?cmd=updatePwd",
			type:"post",
			dataType:"json",
			data:$("#updatepwd").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip)					
					//清空表单
					$("#updatepwd").form("clear");
					//更新table表格
					$("#pwdTable").datagrid("reload");
				}
			}
		})
	})
		
})