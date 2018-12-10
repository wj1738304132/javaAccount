package com.chinasoft.cto.capitalAccount.dao;

import java.util.List;

import com.chinasoft.cto.capitalAccount.model.User;

public interface AdminDaoInterface {

	List<User> queryAllUser(User user, int start, int length);

	List<User> queryFrozenUser(User user);

	List<User> queryEnableUser(User user);

	boolean addUser(User user);

	List<User> queryAdmin(User user);

	boolean updateAdmin(User user);

	boolean deleteUser(String[] ids);

	List<User> queryInfo(User user);

	boolean frozenUser(String[] ids);

	boolean enableUser(String[] ids);

	int queryAllUserCount(User user);

	
}
