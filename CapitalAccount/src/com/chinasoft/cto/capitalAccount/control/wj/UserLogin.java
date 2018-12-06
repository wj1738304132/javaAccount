package com.chinasoft.cto.capitalAccount.control.wj;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.cto.capitalAccount.dao.impl.wj.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.BaseServlet;

import net.sf.json.JSONObject;


@WebServlet("/userLogin")
public class UserLogin extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();

	public void doLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String loginAccount=req.getParameter("loginAccount");
		String loginPwd=req.getParameter("loginPwd");
		
		Account account=new Account();
		account.setAccountid(loginAccount);
		account.setPassword(loginPwd);
		
		UserInfo userInfo=daoInterface.doLogin(account);
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
