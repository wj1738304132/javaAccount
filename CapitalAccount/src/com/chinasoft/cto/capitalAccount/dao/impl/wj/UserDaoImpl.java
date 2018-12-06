package com.chinasoft.cto.capitalAccount.dao.impl.wj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.cto.capitalAccount.dao.wj.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.Admin;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;
import com.chinasoft.cto.capitalAccount.untils.wj.DBUtil;




public class UserDaoImpl implements DaoInterface {
   static{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	@Override
	public List<UserInfo> queryUserInfo(Account account) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/work", "root", "root");
			pst=conn.prepareStatement("select * from personinfo where accountid=?");
			
			pst.setString(1, account.getAccountid());
			ResultSet rs=pst.executeQuery();
			
			List<UserInfo> list=new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setPersonid(rs.getString(1));
				userInfo.setRealname(rs.getString(3));
				userInfo.setBirthday(rs.getString(5));
				userInfo.setSex(rs.getString(6));
				userInfo.setAddress(rs.getString(8));
				userInfo.setTelephone(rs.getString(9));
				userInfo.setCardid(rs.getString(7));
				list.add(userInfo);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return null;

	}

	@Override
	
	public boolean updateUser(UserInfo userinfo) {
		int rows=DBUtil.update("update personinfo set realname=?,birthday=?,sex=?,address=?,telephone=?,cardid=? where personid=?",
				userinfo.getRealname(),userinfo.getBirthday(),userinfo.getSex(),userinfo.getAddress(),userinfo.getTelephone(),userinfo.getCardid(),userinfo.getPersonid());
		if(rows>0){
			return true;
		}
		return false;
	}

	
	

	@Override
	public int updatePwd(Account account) {
		String sql="UPDATE account SET `password`=? WHERE accountid=?";
		try {
			int rows=DBUtil.update(sql,account.getPassword() ,account.getAccountid());
			return rows;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public String getPwd(Account account) {
		String sql="select password from account where accountid=?";
		try {
			
			Account acc=DBUtil.queryOne(Account.class, sql, account.getAccountid());
			
			return acc.getPassword();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserInfo> queryUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	//µÇÂ½²éÑ¯
	@Override
	public UserInfo doLogin(Account account) {
		String sql="SELECT * FROM personinfo natural JOIN account WHERE accountid=? AND `password`=?;";
		try {
			UserInfo acc=DBUtil.queryOne(UserInfo.class, sql, account.getAccountid(),account.getPassword());
			return acc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public Admin doLogin(Admin admin) {
		String sql="SELECT * FROM admin WHERE adminName=? AND adminPassword=?;";
		try {
			Admin ad=DBUtil.queryOne(Admin.class, sql, admin.getAdminName(),admin.getAdminPassword());
			System.out.println(admin.getAdminName());
			return ad;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
}
