package com.chinasoft.cto.capitalAccount.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.cto.capitalAccount.dao.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.UserInfo;


public class UserDaoImpl implements DaoInterface {

	@Override
	public List<UserInfo> queryUserInfo() {
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/work", "root", "root");
			pst=conn.prepareStatement("select * from personinfo");
			ResultSet rs=pst.executeQuery();
			List<UserInfo> list=new ArrayList<UserInfo>();
			while (rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setRealname(rs.getString(3));
				userInfo.setBirthday(rs.getString(5));
				userInfo.setSex(rs.getString(6));
				userInfo.setAddress(rs.getString(8));
				userInfo.setTelephone(rs.getString(9));
				userInfo.setCardid(rs.getString(7));		
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
	public static void main(String[] args) {
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.queryUserInfo();
	}

}
