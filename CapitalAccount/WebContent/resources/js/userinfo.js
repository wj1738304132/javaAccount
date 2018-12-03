$(function(){
	$("#addBtn").click(function(){
		$('#w').window('open');
	})
	$("#cancelBtn").click(function(){
		$('#w').window('close');
	})
	$("#saveBtn").click(function(){
		$.ajax({
			url:"userServlet?cmd=addUser",
			type:"post",
			dataType:"json",
			data:$("#addform").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip)
					$('#w').window('close');
					//清空表单
					$("#addform").form("clear");
					//更新table表格
					$("#userTable").datagrid("reload");
				}
			}
		})
	})
	$("#updateBtn").click(function(){
		//获取选中的行
		var row=$("#userTable").datagrid("getSelected");
		if(!row){
			alert("请选中要修改的行")
			return;
		}
		$("#updateWindow").window("open");
//		$("#userId").val(row.userId);
//		$("#realName").textbox("setValue",row.realName);
//		$("#realName").textbox("setValue",row.realName);
//		$("#userSex").combobox("setValue",row.userSex);
		$("#updateform").form("load",row);
		
	})
	$("#cancelUpdateBtn").click(function(){
		$('#updateWindow').window('close');
	})
	$("#saveUpdateBtn").click(function(){
		
		$.ajax({
			url:"userServlet?cmd=updateUser",
			type:"post",
			dataType:"json",
			data:$("#updateform").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip)
					$('#updateWindow').window('close');
					//清空表单
					$("#updateform").form("clear");
					//更新table表格
					$("#userTable").datagrid("reload");
				}
			}
		})
	})
	$("#deleteBtn").click(function(){
		//获取要删除的行的userId
		var rows=$("#userTable").datagrid("getSelections");
		
		if(rows.length==0){
			alert("请选中要删除的行")
			return;
		}
		var idArray=new Array();
		$(rows).each(function(index,row){
			idArray[index]=row.userId;
//			idArray.push(row.userId);
		})
		alert(idArray)
		$.ajax({
			url:"userServlet?cmd=deleteUser",
			type:"post",
			dataType:"json",
			data:{
				ids:idArray.toString()
			},
			success:function(resp){
				alert(resp.tip);
				if(resp.state){
					//更新table表格
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