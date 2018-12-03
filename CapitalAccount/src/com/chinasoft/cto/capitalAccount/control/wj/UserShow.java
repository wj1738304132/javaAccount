package com.chinasoft.cto.capitalAccount.control.wj;


import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.DaoInterface;
import com.chinasoft.cto.capitalAccount.dao.impl.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.model.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.BaseServlet;


@WebServlet("/userShow")
public class UserShow extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();
	
	public void queryUser(HttpServletRequest req,HttpServletResponse resp){
	List<UserInfo> userInfo=daoInterface.queryUserInfo();
	
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
