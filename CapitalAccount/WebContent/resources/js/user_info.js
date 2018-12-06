$(function(){
	$("#saveBtn").click(function(){
		$.ajax({
			url:"userServlet?cmd=addUser",
			type:"post",
			datatype:"json",
			data:$("#addform").serialize(),
			success:function(resp){
				
				if(resp.state){
					
					$("#addform").form("clear");
					$("#userTable").datagrid("reload");
				}
			}
		})
	})
	
	$("#saveBtn1").click(function(){
		$.ajax({
			url:"userServlet?cmd=addUser1",
			type:"post",
			datatype:"json",
			data:$("#addform1").serialize(),
			success:function(resp){
				
				if(resp.state){
					
					$("#addform1").form("clear");
					$("#userTable").datagrid("reload");
				}
			}
		})
	})
	$("#saveBtn2").click(function(){
		$.ajax({
			url:"userServlet?cmd=addUser2",
			type:"post",
			datatype:"json",
			data:$("#addform2").serialize(),
			success:function(resp){
				
				if(resp.state){
					
					$("#addform2").form("clear");
					$("#userTable").datagrid("reload");
				}
			}
		})
	})
	
	$("#searchBtn").click(function(){
		$.ajax({
			url:"userServlet?cmd=queryUser",
			type:"post",
			dataType:"json",
			data:$("#searchform").serialize(),
			success:function(resp){
				$("#userTable").datagrid("loadData",resp.rows);
			}
		})
	})
	
})
s
