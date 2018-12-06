$(function(){

	
	$("#login").click(function(){
		$.ajax({
			url:"userLogin?cmd=doLogin",
			type:"post",
			dataType:"json",
			data:$("#loginForm").serialize(),
			success:function(resp){
//				var data=eval("("+resp+")");
				if(resp.state){
					alert("恭喜"+resp.user.realname+"登录了");
					location.href="views/UserMain.jsp"
				}else{
					$(".panel-title").html(resp.tip);
				}
			}
		})
	});
})