package com.chinasoft.cto.capitalAccount.dao.impl;


import java.util.ArrayList;
import java.util.List;



import com.chinasoft.cto.capitalAccount.dao.DaoInterface;
import com.chinasoft.cto.capitalAccount.model.UserInfo;
import com.chinasoft.cto.capitalAccount.utils.DBUtil;

public class DaoInterfaceImpl implements DaoInterface{
	


	@Override
	public boolean addUser(UserInfo userInfo) {
		String sql="insert into transaction_log(otherid,money,datetime,typeid) values(?,?,now(),?)";
		DBUtil.update(sql,userInfo.getOtherid(), userInfo.getMoney(),userInfo.getTypeid());
		
		return false;
		
	}
	
	@Override
	public boolean addUser1(UserInfo userInfo) {
		String sql="insert into transaction_log(otherid,money,datetime,typeid) values(?,?,now(),?)";
		DBUtil.update(sql,userInfo.getOtherid(), userInfo.getMoney(),userInfo.getTypeid());
		
		return false;
		
	}

	@Override
	public boolean addUser2(UserInfo userInfo) {
		String sql="insert into transaction_log(otherid,money,datetime,typeid) values(?,?,now(),?) ";
	DBUtil.update(sql, userInfo.getOtherid(),userInfo.getMoney(),userInfo.getTypeid());
	return false;
	}

	public List<UserInfo> queryUserInfo(UserInfo userInfo){
		StringBuffer sql=new StringBuffer("select * from " + 
				"transaction_log tl left join transaction_type tt on tl.typeid=tt.typeid;");
		List<Object> params=new ArrayList<Object>();
		
			try {
				return DBUtil.queryAll(UserInfo.class, sql.toString(), params.toArray());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return null;
		
	}



}
