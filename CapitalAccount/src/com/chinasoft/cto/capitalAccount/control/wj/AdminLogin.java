package com.chinasoft.cto.capitalAccount.control.wj;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.impl.wj.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.Admin;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.BaseServlet;

@WebServlet("/adminLogin")
public class AdminLogin extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();

	public void doLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String loginAccount=req.getParameter("loginAccount");
		String loginPwd=req.getParameter("loginPwd");
		
		Admin admin=new Admin();
		admin.setAdminName(loginAccount);
		admin.setAdminPassword(loginPwd);
		
		Admin userInfo=daoInterface.doLogin(admin);
		            //设置编码集
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
		
		if(userInfo!=null){
			HttpSession session=req.getSession();
			session.setAttribute("userinfo", userInfo);
			
			
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("state", true);
			jsonObj.put("tip", "登录成功");
			jsonObj.put("user", JSONObject.fromObject(userInfo));
			resp.getWriter().print(jsonObj);
			
		}else{
			String json="{state:false,tip:'登录失败，用户名或密码错误'}";
			resp.getWriter().print(json);
		}
	}

}
