////修改状态
//function updateType(val,row,index){
//	return '<a href="javascript:void(0)" onclick="updateType('+index+')">冻结</a>';
//}
////删除本条记录
//function deleteUser(val,row,index){
//	return '<a href="javascript:void(0)" onclick="deleteUser('+index+')">删除</a>';
//}
//function deleteUser(index){
//	$('#allUser').datagrid('selectRow',index);
//	var rows = $('#allUser').datagrid('getSelected');
//	var idsArray=new Array();
//	$(rows).each(function(index,row){
//		idsArray.push(row.accountid);
//	})
//	if(row){
//		$.ajax({
//			url:"deleteUserServlet?cmd=deleteUser",
//			type:"post",
//			dataType:"json",
//			data:{
//				ids:idsArray.toString()
//			},
//			success:function(resp){
//				$("#allUser").datagrid("loadData",resp.rows);
//			}
//		})
//	}
//}
//查看个人信息
//function formatOper(val,row,index){
//	return '<a href="javascript:void(0)" onclick="editUser('+index+')">查看个人信息</a>';
//}
//function editUser(index){
//	$('#allUser').datagrid('selectRow',index);
//	var row = $('#allUser').datagrid('getSelected');
//	if(row){
//		$.ajax({
//			url:"allUserServlet?cmd=queryUser",
//			type:"post",
//			dataType:"json",
//			data:$("#searchForm").serialize(),
//			success:function(resp){
//				$("#allUser").datagrid("loadData",resp.rows);
//			}
//		})
//	}
//}
$(function(){
	//查询按钮
	$("#searchBtn").click(function(){
		$.ajax({
			url:"adminServlet?cmd=queryUser",
			type:"post",
			dataType:"json",
			data:$("#searchForm").serialize(),
			success:function(resp){
				$("#allUser").datagrid("loadData",resp.rows);
			}
		})		
	})
	$("#allUser").datagrid({
	    onLoadSuccess : function () {
	        $(this).datagrid("fixRownumber");
	    }
	})
	//冻结按钮
	$("#frozenBtn").click(function(){
		var rows=$("#allUser").datagrid("getSelected");	
		if(!rows){
			alert("请选择要冻结的账户");
			return;
		}
		$.ajax({
			url:"adminServlet?cmd=frozenUser",
			type:"post",
			dataType:"json",
			data:{
				ids2:rows.accountid
			},
			success:function(resp){
				//更新表格数据
				$("#allUser").datagrid("reload");
			}	
		})
	})
	//启用按钮
	$("#enableBtn").click(function(){
		var rows=$("#allUser").datagrid("getSelected");	
		if(!rows){
			alert("请选择要启用的账户");
			return;
		}
		$.ajax({
			url:"adminServlet?cmd=enableUser",
			type:"post",
			dataType:"json",
			data:{
				ids4:rows.accountid
			},
			success:function(resp){
				$("#allUser").datagrid("reload");
			}
		})		
	})	
	//删除按钮
	$("#deleteBtn").click(function(){
		//获取选择的行
		var rows=$("#allUser").datagrid("getSelections");		
		if(rows.length==0){
			alert("请选择要删除的信息");
			return;
		}
		var idsArray=new Array();
		$(rows).each(function(index,row){
			idsArray.push(row.accountid);
		})		
		$.ajax({
			url:"adminServlet?cmd=deleteUserInfo",
			type:"post",
			dataType:"json",
			data:{
				ids3:idsArray.toString()
			},
			success:function(resp){
				$("#allUser").datagrid("reload");
			}
		})
	})
	//个人信息按钮
	$("#queryBtn").click(function(){
		//获取选择的行
		var rows=$("#allUser").datagrid("getSelected");	
		if(!rows){
			alert("请选择要查看个人信息的用户");
			return;
		}
		$("#QueryInfo").window("open");
		$.ajax({
			url:"adminServlet?cmd=queryInfo",
			type:"post",
			dataType:"json",
			data:{
				ids:rows.accountid
			},
			success:function(resp){
				$("#queryInfo").datagrid("loadData",resp.rows);
			}
		})	
	})
	//查询冻结按钮
	$("#searchFrozenBtn").click(function(){
		$.ajax({
			url:"adminServlet?cmd=queryFrozenUser",
			type:"post",
			dataType:"json",
			data:$("#searchForm").serialize(),
			success:function(resp){
				$("#allUser").datagrid("loadData",resp.rows);
			}
		})		
	})
	//查询启用按钮
	$("#searchEnableBtn").click(function(){
		$.ajax({
			url:"adminServlet?cmd=queryEnableUser",
			type:"post",
			dataType:"json",
			data:$("#searchForm").serialize(),
			success:function(resp){
				$("#allUser").datagrid("loadData",resp.rows);
			}
		})		
	})
	//开户保存
	$("#addUserSaveBtn").click(function(){
		$.ajax({
			url:"adminServlet?cmd=addUser",
			type:"post",
			dataType:"json",
			data:$("#addform").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip)
					//清空表单
					$("#addform").form("clear");
					//更新table表格
					$("#addUser").datagrid("reload");
				}
			}
		})
	})
	$("#updateBtn").click(function(){
		//获取选中的行
		var row=$("#goodsTable").datagrid("getSelected");
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
	//修改后台登录密码
	$("#updatePwdSaveBtn").click(function(){		
		$.ajax({
			url:"adminServlet?cmd=updatePwd",
			type:"post",
			dataType:"json",
			data:$("#updateform").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip);
					//清空表单
					$("#updateform").form("clear");
				}
			}
		})
	})
	
})

function myformat(val,row,index){
//	     var options = $("#allUser").datagrid('getPager').data("pagination").options; 
//	     var currentPage = options.pageNumber;
//	     var pageSize = options.pageSize;
//	     return (pageSize * (currentPage -1))+(index+1);
	return index+1;
}
	