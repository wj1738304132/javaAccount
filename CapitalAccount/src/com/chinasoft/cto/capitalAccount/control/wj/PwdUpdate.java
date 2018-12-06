package com.chinasoft.cto.capitalAccount.control.wj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.impl.wj.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.BaseServlet;

@WebServlet("/pwdUpdate")
public class PwdUpdate extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();
	public void updatePwd(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String nowpwd=req.getParameter("nowpwd");
		String newpwd=req.getParameter("newpwd");
		String confirmpwd=req.getParameter("confirmpwd");
		
		//从登陆界面拿到账户信息
		HttpSession session=req.getSession();
		UserInfo userInfo1=(UserInfo) session.getAttribute("userinfo");
		
		//将id放入Account对象
		Account account=new Account();
		account.setAccountid(userInfo1.getAccountid());
		
		//json
		JSONObject obj=new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//判断前后密码的一致性
		if (newpwd.equals(confirmpwd)) {
			//从数据库得到当前密码
			String nowpwd1=daoInterface.getPwd(account);
			
				//判断数据库密码与输入的旧密码是否相同	
			if(nowpwd.equalsIgnoreCase(nowpwd1)){
				//将新密码设置到数据库
				account.setPassword(newpwd);
				int row=daoInterface.updatePwd(account);
				obj.put("state", true);
				obj.put("tip", "修改成功");			
			}else{
				obj.put("state", true);
				obj.put("tip", "旧密码输入错误");
				
			}			
			
			
		}else {
			obj.put("state", true);
			obj.put("tip", "前后密码输入不一致，请检查");	
			
		}
		out.print(obj);
		out.flush();
		out.close();
			
		}
		
}
