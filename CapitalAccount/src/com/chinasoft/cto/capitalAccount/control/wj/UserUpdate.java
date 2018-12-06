package com.chinasoft.cto.capitalAccount.control.wj;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.impl.wj.UserDaoImpl;
import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.BaseServlet;


@WebServlet("/userUpdate")
public class UserUpdate extends BaseServlet{
	DaoInterface daoInterface=new UserDaoImpl();
	
	public void updateUser(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String personid=req.getParameter("personid");
		String realname=req.getParameter("realname");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");
		String address=req.getParameter("address");
		String telephone=req.getParameter("telephone");
		String cardid=req.getParameter("cardid");
		
		UserInfo userinfo=new UserInfo();
		userinfo.setPersonid(personid);
		userinfo.setRealname(realname);
		userinfo.setBirthday(birthday);
		userinfo.setSex(sex);
		userinfo.setAddress(address);
		userinfo.setTelephone(telephone);
		userinfo.setCardid(cardid);
		//设置编码集
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		boolean flag=daoInterface.updateUser(userinfo);
		JSONObject obj=new JSONObject();		
		if(flag){
			obj.put("state", true);
			obj.put("tip", "修改成功");			
		}else{
			obj.put("state", true);
			obj.put("tip", "修改失败");
			
		}
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}
	
}
