
$(function(){
	//分页查询
	var pageSize=5;//每页数量
	var pageNum=1;//默认第一页
	var total=30;
	var params={
			pageSize:pageSize,
			pageNum:pageNum,
	}
	var initPage=function(){
		$("#AllUserPage").pagination({
			total:total,
			pageSize:params.pageSize,
			pageList: [5,10,20,50],
			beforePageText: '第',
			afterPageText: '页    共 {pages} 页',  
			displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',		
			onSelectPage:function(pageNumber, pageSize){
				params.pageNum=pageNumber;
				params.pageSize=pageSize;
				queryAllUser();
			}
		})
	}
	var queryAllUser=function(){
		$.ajax({
			url:"adminServlet?cmd=queryUser",
			type:"post",
			dataType:"json",
			data:params,
			success:function(resp){
//				if(resp.total>0){
					$("#allUser").datagrid("loadData",resp.rows);
//					total=resp.total;
					initPage();
//				}				
			}
		})
	}
	queryAllUser();
	
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
//	$("#allUser").datagrid({
//	    onLoadSuccess : function () {
//	        $(this).datagrid("fixRownumber");
//	    }
//	})
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
//				$("#allUser").datagrid("reload");
				queryAllUser();
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
//				$("#allUser").datagrid("reload");
				queryAllUser();
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
//				$("#allUser").datagrid("reload");
				queryAllUser();
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
//序号
function myformat(val,row,index){
//	     var options = $("#allUser").datagrid('getPager').data("pagination").options; 
//	     var currentPage = options.pageNumber;
//	     var pageSize = options.pageSize;
//	     return (pageSize * (currentPage -1))+(index+1);
	return index+1;
}
	