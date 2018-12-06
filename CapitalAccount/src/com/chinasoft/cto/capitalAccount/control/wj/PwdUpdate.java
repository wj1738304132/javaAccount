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
		
		//�ӵ�½�����õ��˻���Ϣ
		HttpSession session=req.getSession();
		UserInfo userInfo1=(UserInfo) session.getAttribute("userinfo");
		
		//��id����Account����
		Account account=new Account();
		account.setAccountid(userInfo1.getAccountid());
		
		//json
		JSONObject obj=new JSONObject();
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//�ж�ǰ�������һ����
		if (newpwd.equals(confirmpwd)) {
			//�����ݿ�õ���ǰ����
			String nowpwd1=daoInterface.getPwd(account);
			
				//�ж����ݿ�����������ľ������Ƿ���ͬ	
			if(nowpwd.equalsIgnoreCase(nowpwd1)){
				//�����������õ����ݿ�
				account.setPassword(newpwd);
				int row=daoInterface.updatePwd(account);
				obj.put("state", true);
				obj.put("tip", "�޸ĳɹ�");			
			}else{
				obj.put("state", true);
				obj.put("tip", "�������������");
				
			}			
			
			
		}else {
			obj.put("state", true);
			obj.put("tip", "ǰ���������벻һ�£�����");	
			
		}
		out.print(obj);
		out.flush();
		out.close();
			
		}
		
}
