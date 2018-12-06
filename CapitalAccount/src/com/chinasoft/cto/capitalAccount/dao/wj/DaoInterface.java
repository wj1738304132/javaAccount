package com.chinasoft.cto.capitalAccount.dao.wj;

import java.util.List;











import com.chinasoft.cto.capitalAccount.model.wj.Account;
import com.chinasoft.cto.capitalAccount.model.wj.Admin;
import com.chinasoft.cto.capitalAccount.model.wj.UserInfo;



public interface DaoInterface {
	

	List<UserInfo> queryUserInfo();

	

	boolean updateUser(UserInfo userinfo);



	int updatePwd(Account account);



	String getPwd(Account account);



	List<UserInfo> queryUserInfo(Account account);



	UserInfo doLogin(Account account);



	Admin doLogin(Admin admin);



	



	
}
