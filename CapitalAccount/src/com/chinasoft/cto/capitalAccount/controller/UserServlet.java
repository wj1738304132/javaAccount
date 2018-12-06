package com.chinasoft.cto.capitalAccount.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chinasoft.cto.capitalAccount.dao.DaoInterface;
import com.chinasoft.cto.capitalAccount.dao.impl.DaoInterfaceImpl;
import com.chinasoft.cto.capitalAccount.model.UserInfo;

import com.chinasoft.cto.capitalAccount.utils.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet{

	DaoInterface userDao=new DaoInterfaceImpl();

	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	public void addUser(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        
        String typeid=req.getParameter("typeid");
		
		String money=req.getParameter("money");
		String otherid=req.getParameter("otherid");
		String datetime=req.getParameter("datetime");
		
		
		UserInfo userInfo=new UserInfo();
		userInfo.setDatetime(datetime);
		userInfo.setOtherid(otherid);
		userInfo.setMoney(money);
		userInfo.setTypeid(typeid);
		


		boolean flag=userDao.addUser(userInfo);
		JSONObject obj=new JSONObject();
		if(flag) {
			obj.put("state", true);
			obj.put("tip", "存款成功");
		}else {
			obj.put("state", false);
			obj.put("tip", "存款失败");
		}
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	public void addUser1(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		String money=req.getParameter("money");
		String otherid=req.getParameter("otherid");
		String datetime=req.getParameter("datetime");
		String typeid=req.getParameter("typeid");
		
		UserInfo userInfo=new UserInfo();
		userInfo.setDatetime(datetime);
		userInfo.setOtherid(otherid);
		userInfo.setMoney(money);
		userInfo.setTypeid(typeid);
		

		boolean flag=userDao.addUser1(userInfo);
		JSONObject obj=new JSONObject();
		if(flag) {
			obj.put("state", true);
			obj.put("tip", "取款成功");
		}else {
			obj.put("state", false);
			obj.put("tip", "取款失败");
		}
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	
	public void addUser2(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		String money=req.getParameter("money");
		String otherid=req.getParameter("otherid");
		String datetime=req.getParameter("datetime");
		String typeid=req.getParameter("typeid");
		
		
		UserInfo userInfo=new UserInfo();
		userInfo.setOtherid(otherid);
		userInfo.setDatetime(datetime);
		userInfo.setMoney(money);
		userInfo.setTypeid(typeid);
		
		boolean flag=userDao.addUser2(userInfo);
		JSONObject obj=new JSONObject();
		if(flag) {
			
			obj.put("state", true);
			obj.put("tip", "转账成功");
		}else {
			obj.put("state", false);
			obj.put("tip", "转账失败");
		}
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	
	public void queryUser(HttpServletRequest req,HttpServletResponse resp) {
		
		
		String transaction_id=req.getParameter("transaction_id");
		String accountid=req.getParameter("accountid");
		String typeid=req.getParameter("typeid");
		String otherid=req.getParameter("otherid");
		String money=req.getParameter("money");
		String datetime=req.getParameter("datetime");
		
		
		
		UserInfo userInfo=new UserInfo();
		userInfo.setAccountid(accountid);
		userInfo.setDatetime(datetime);
		userInfo.setMoney(money);
		userInfo.setOtherid(otherid);
		userInfo.setTransaction_id(transaction_id);
		userInfo.setTypeid(typeid);
		
		List<UserInfo> userInfos=userDao.queryUserInfo(userInfo);
		
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(userInfos));
		
		
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
