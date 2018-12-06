$(function(){
//	$('.typeId').combobox({
//	    url:'goodsServlet?cmd=queryTypes',
//	    valueField:'typeId',
//	    textField:'typeName'
//	});
//	$.ajax({
//		url:"goodsServlet?cmd=queryTypes",
//		type:"post",
//		dataType:"json",
//		success:function(types){
//			var data=new Array();
//			data.push({"typeId":0,"typeName":"全部"});
//			$(types).each(function(index,type){
//				data.push(type);
//			})
//			$('.typeId').combobox("loadData",data);
//		}
//	})
	
	
	$("#searchBtn").click(function(){
		$.ajax({
			url:"newsServlet?cmd=queryNews",
			type:"post",
			dataType:"json",
			data:$("#searchform").serialize(),
			success:function(resp){
				$("#newsTable").datagrid("loadData",resp.rows);
			}
		})
	})
	$("#deleteBtn").click(function(){
		//获取选择的行
		var rows=$("#newsTable").datagrid("getSelections");
		
		if(rows.length==0){
			alert("请选择要删除的文章");
			return;
		}
		var idsArray=new Array();
		$(rows).each(function(index,row){
			idsArray[index]=row.newsid
//			idsArray.push(row.newsid);
		})
		
		$.ajax({
			url:"newsServlet?cmd=deleteNews",
			type:"post",
			dataType:"json",
			data:{
				newsid:idsArray.toString()
			},
			success:function(resp){
				$("#newsTable").datagrid("reload");
			}
		})
	})
	
	$("#addBtn").click(function(){
//		$('#w').window('open');
//	})
//	$("#saveBtn").click(function(){
		$.ajax({
			url:"newsServlet?cmd=addNews",
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
					$("#newsTable").datagrid("reload");
				}
			}
		})
	})
	$("#cancelBtn").click(function(){
		$('#w').window('close');
	})
	$("#updateBtn").click(function(){
		//获取选中的行
		var row=$("#newsTable").datagrid("getSelected");
		if(!row){
			alert("请选中要修改的新闻")
			return;
		}
		$("#updateWindow").window("open");
//		$("#userId").val(row.userId);
//		$("#realName").textbox("setValue",row.realName);
//		$("#realName").textbox("setValue",row.realName);
//		$("#userSex").combobox("setValue",row.userSex);
		$("#updateform").form("load",row);
		
	})
	$("#saveUpdateBtn").click(function(){
		
		$.ajax({
			url:"newsServlet?cmd=updateNews",
			type:"post",
			dataType:"json",
			data:$("#updateform").serialize(),
			success:function(resp){
				if(resp.state){
					alert(resp.tip);
					$('#updateWindow').window('close');
					//清空表单
					$("#updateform").form("clear");
					//更新table表格
					$("#newsTable").datagrid("reload");
				}
			}
		})
	})
})