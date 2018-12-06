package com.chinasoft.cto.capitalAccount.control.wj;


import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.impl.wj.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.BaseServlet;


@WebServlet("/userShow")
public class UserShow extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();
	
	
	public void queryUser(HttpServletRequest req,HttpServletResponse resp){
		
		        //从登陆界面拿到账户信息
				HttpSession session=req.getSession();
				UserInfo userInfo1=(UserInfo) session.getAttribute("userinfo");
				
				//将id放入Account对象
				Account account=new Account();
				account.setAccountid(userInfo1.getAccountid());
		
		List<UserInfo> userInfo=daoInterface.queryUserInfo(account);

	JSONObject json=new JSONObject();
	json.put("rows", JSONArray.fromObject(userInfo));
	try {
		resp.getWriter().print(json);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
