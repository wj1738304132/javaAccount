package com.chinasoft.cto.capitalAccount.control.chen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javafx.scene.control.Alert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chinasoft.cto.capitalAccount.dao.AdminDaoInterface;
import com.chinasoft.cto.capitalAccount.dao.impl.AdminDaoImpl;
import com.chinasoft.cto.capitalAccount.model.User;
import com.chinasoft.cto.capitalAccount.untils.BaseServlet;
@WebServlet("/adminServlet")
public class AdminServlet extends BaseServlet{
	AdminDaoInterface adminDao=new AdminDaoImpl();
	/**
	 * 查看所有用户
	 * @param req
	 * @param resp
	 */
	public void queryUser(HttpServletRequest req,HttpServletResponse resp){
		String realname=req.getParameter("realName");
		User user=new User();
		if(realname!=null){
			user.setRealname(realname);
		}
		List<User> users=adminDao.queryAllUser(user);
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(users));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 开户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void addUser(HttpServletRequest req,HttpServletResponse resp){
		String accountid=req.getParameter("accountid");
		String password=req.getParameter("password");
		String passwordNew=req.getParameter("passwordNew");
		String balance=req.getParameter("balance");
		String personid=req.getParameter("personid");
		String realname=req.getParameter("realname");
		String birthday=req.getParameter("birthday");
		String sex=req.getParameter("sex");
		String address=req.getParameter("address");
		String telephone=req.getParameter("telephone");
		String cardid=req.getParameter("cardid");
		User user=new User();
		if (password!=null && !password.equals("") && password.equals(passwordNew)) {
			user.setAccountid(accountid);
			user.setPassword(passwordNew);
			user.setBalance(balance);
			user.setPersonid(personid);
			user.setRealname(realname);
			user.setBirthday(birthday);
			user.setSex(sex);
			user.setAddress(address);
			user.setTelephone(telephone);
			user.setCardid(cardid);
		}
		boolean flag=adminDao.addUser(user);
		JSONObject obj=new JSONObject();
		if(flag){
			obj.put("state", true);
			obj.put("tip", "添加成功");
		}else {
			obj.put("state", false);
			obj.put("tip", "添加失败");
		}
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * 删除账户
	 */
	public void deleteUserInfo(HttpServletRequest req, HttpServletResponse resp){
//		String id=req.getParameter("ids");
		String[] ids=req.getParameter("ids3").split(",");
		boolean flag=adminDao.deleteUser(ids);
		JSONObject obj=new JSONObject();		
		if(flag){
			obj.put("state", true);
			obj.put("tip", "删除成功");			
		}else{
			obj.put("state", false);
			obj.put("tip", "删除失败");
			
		}
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * 查看个人信息
	 * @param req
	 * @param resp
	 */
	public void queryInfo(HttpServletRequest req,HttpServletResponse resp){
//		String id=req.getParameter("ids");
		String ids=req.getParameter("ids");
		User user=new User();
		user.setAccountid(ids);
		List<User> list=adminDao.queryInfo(user);
		JSONObject json=new JSONObject();		
		json.put("rows", JSONArray.fromObject(list));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查看冻结
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryFrozenUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		String realname=req.getParameter("realName");
		String realname=req.getParameter("realName");
		User user=new User();
		if(realname!=null){
			user.setRealname(realname);
		}
		List<User> users=adminDao.queryFrozenUser(user);
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(users));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查看启用
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryEnableUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String realname=req.getParameter("realName");
		User user=new User();
		if(realname!=null && !realname.equals("")){
			user.setRealname(realname);
		}
		List<User> users=adminDao.queryEnableUser(user);
		JSONObject json=new JSONObject();
		json.put("rows", JSONArray.fromObject(users));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改密码
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void updatePwd(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String adminPasswordOld=req.getParameter("adminPasswordOld");
		String adminPasswordNew1=req.getParameter("adminPasswordNew1");
		String adminPasswordNew2=req.getParameter("adminPasswordNew2");
		User user=new User();
		//登录界面需要把用户名和密码传入作用于session的admin里
//		String adminName="张三";
		String adminName=(String) req.getAttribute("admin");
		user.setAdminName(adminName);
		List<User> pwd1=adminDao.queryAdmin(user);
		String pwd=pwd1.get(0).getAdminPassword();
		JSONObject obj=new JSONObject();
		PrintWriter out=resp.getWriter();
		if (pwd.equals(adminPasswordOld) && adminPasswordNew1.equals(adminPasswordNew2)) {
			user.setAdminPassword(adminPasswordNew2);
			boolean flag=adminDao.updateAdmin(user);
			if (flag) {
				obj.put("state", true);
				obj.put("tip", "修改成功");
			}else {
				obj.put("state", true);
				obj.put("tip", "修改失败");
			}	
		}		
		out.print(obj);
		out.flush();
		out.close();
	}
	/**
	 * 冻结账户
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void frozenUser(HttpServletRequest req,HttpServletResponse resp) throws IOException{
//		String id=req.getParameter("ids");
		String[] ids=req.getParameter("ids2").split(",");
		boolean flag=adminDao.frozenUser(ids);
		JSONObject obj=new JSONObject();		
		if(flag){
			obj.put("state", true);
			obj.put("tip", "冻结成功");			
		}else{
			obj.put("state", false);
			obj.put("tip", "冻结失败");
			
		}
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 启用账户
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void enableUser(HttpServletRequest req,HttpServletResponse resp) throws IOException{
//		String id=req.getParameter("ids");
		String[] ids=req.getParameter("ids4").split(",");
		boolean flag=adminDao.enableUser(ids);
		JSONObject obj=new JSONObject();		
		if(flag){
			obj.put("state", true);
			obj.put("tip", "启用成功");			
		}else{
			obj.put("state", false);
			obj.put("tip", "启用失败");
			
		}
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
