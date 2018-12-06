package com.chinasoft.cto.capitalAccount.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;


import com.chinasoft.cto.capitalAccount.dao.AdminDaoInterface;
import com.chinasoft.cto.capitalAccount.model.User;
import com.chinasoft.cto.capitalAccount.untils.DBUtil;

public class AdminDaoImpl implements AdminDaoInterface{
	/**
	 * 查看所有的用户
	 */
	@Override
	public List<User> queryAllUser(User user) {
		StringBuffer sql=new StringBuffer("select pa.accountid,pa.balance,pa.realname,pa.address,pa.cardid,pa.telephone,s.name,pa.mark from "+
				"(select a.statusid,a.balance,p.accountid,p.realname,p.address,p.cardid,p.telephone,a.mark "+
				"from personinfo p left join account a on p.accountid=a.accountid) pa "+
				"left join status s on pa.statusid=s.statusid where 1=1 and pa.mark=0 ");
		List<Object> params=new ArrayList<Object>();
		if(user.getRealname()!=null && !user.getRealname().equals("")){
			sql.append(" and pa.realname like ?");
			params.add(user.getRealname()+"%");
		}
		
//		sql.append(" limit ?,?");
//		params.add(start);
//		params.add(length);
		try {
			return DBUtil.queryAll(User.class, sql.toString(), params.toArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查看冻结的用户
	 */
	@Override
	public List<User> queryFrozenUser(User user) {
		StringBuffer sql=new StringBuffer("select pa.accountid,pa.balance,pa.realname,pa.address,pa.cardid,pa.telephone,s.name from "+ 
				"(select a.statusid,a.balance,p.accountid,p.realname,p.address,p.cardid,p.telephone "+
				"from personinfo p left join account a on p.accountid=a.accountid) pa "+
				"left join status s on pa.statusid=s.statusid where pa.statusid=0");
		List<Object> params=new ArrayList<Object>();
		if(user.getRealname()!=null && !user.getRealname().equals("")){
			sql.append(" and pa.realname like ?");
			params.add("%"+user.getRealname()+"%");
		}
		try {
			return DBUtil.queryAll(User.class, sql.toString(), params.toArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查看启用的用户
	 */
	@Override
	public List<User> queryEnableUser(User user) {
		StringBuffer sql=new StringBuffer("select pa.accountid,pa.balance,pa.realname,pa.address,pa.cardid,pa.telephone,s.name from "+ 
				"(select a.statusid,a.balance,p.accountid,p.realname,p.address,p.cardid,p.telephone "+
				"from personinfo p left join account a on p.accountid=a.accountid) pa "+
				"left join status s on pa.statusid=s.statusid where pa.statusid=1");
		List<Object> params=new ArrayList<Object>();
		if(user.getRealname()!=null && !user.getRealname().equals("")){
			sql.append(" and pa.realname like ?");
			params.add("%"+user.getRealname()+"%");
		}
		try {
			return DBUtil.queryAll(User.class, sql.toString(),params.toArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 开户
	 */
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			QueryRunner qr=new QueryRunner();
			String sql="insert into account (accountid,password,balance) values(?,?,?)";
			List<Object> params=new ArrayList<Object>();
			params.add(user.getAccountid());
			params.add(user.getPassword());
			params.add(user.getBalance());
			int rows=qr.update(conn, sql.toString(),params.toArray());
			
			String sql1="insert into personinfo (personid,accountid,realname,birthday,sex,address,telephone,cardid) "
					+ "values (?,?,?,?,?,?,?,?)";
			List<Object> params1=new ArrayList<Object>();
			params1.add(user.getPersonid());
			params1.add(user.getAccountid());
			params1.add(user.getRealname());
			params1.add(user.getBirthday());
			params1.add(user.getSex());
			params1.add(user.getAddress());
			params1.add(user.getTelephone());
			params1.add(user.getCardid());
			int rows1=qr.update(conn, sql1.toString(), params1.toArray());
			conn.commit();
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	/**
	 * 获取登录人员密码
	 */
	@Override
	public List<User> queryAdmin(User user) {
		String sql="select adminPassword from admin where adminName=?";	
		List<Object> params=new ArrayList<Object>();
		params.add(user.getAdminName());
		try {
			return DBUtil.queryAll(User.class, sql.toString(),params.toArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改个人密码
	 */
	@Override
	public boolean updateAdmin(User user) {
		String sql="update admin set adminPassword=? where adminName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getAdminPassword());
		params.add(user.getAdminName());
//		System.out.println(params);
		int rows=DBUtil.update(sql, params.toArray());
		if (rows>0) {
			return true;
		}
		return false;
	}
	/**
	 * 删除选中的用户
	 */
	@Override
	public boolean deleteUser(String[] ids) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			int rows = 0;
			for (String id : ids) {
				rows += DBUtil.update(
						"update account set mark=1 where accountid=?", id);
			}
			if (rows == ids.length) {
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 查看个人信息
	 */
	@Override
	public List<User> queryInfo(User user) {
		String sql="select sa.accountid,sa.name,sa.balance, "
				+ "p.realname,p.birthday,p.sex,p.address,p.telephone,p.cardid from personinfo p left join "
				+ "(select a.accountid,s.name,a.balance from account a left join status s "
				+ "on a.statusid=s.statusid) sa on p.accountid=sa.accountid where p.accountid=?";
			List<Object> list=new ArrayList<Object>();
			list.add(user.getAccountid());
			try {
				return DBUtil.queryAll(User.class, sql.toString(), list.toArray());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
	/**
	 * 点击冻结
	 */
	@Override
	public boolean frozenUser(String[] ids) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			int rows = 0;
			for (String id : ids) {
				rows += DBUtil.update(
						"update account set statusid=0 where accountid=?", id);
			}
			if (rows == ids.length) {
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 点击启用
	 */
	@Override
	public boolean enableUser(String[] ids) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			int rows = 0;
			for (String id : ids) {
				rows += DBUtil.update(
						"update account set statusid=1 where accountid=?", id);
			}
			if (rows == ids.length) {
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

}
