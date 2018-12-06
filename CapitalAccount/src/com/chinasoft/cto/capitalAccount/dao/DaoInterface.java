package com.chinasoft.cto.capitalAccount.dao;



import java.util.List;

import com.chinasoft.cto.capitalAccount.model.UserInfo;

public interface DaoInterface {

	boolean addUser(UserInfo userInfo);

	boolean addUser1(UserInfo userInfo);

	boolean addUser2(UserInfo userInfo);

	List<UserInfo> queryUserInfo(UserInfo userInfo);

	

}
