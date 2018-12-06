package com.chinasoft.cto.capitalAccount.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chinasoft.cto.capitalAccount.dao.NewsDao;
import com.chinasoft.cto.capitalAccount.model.News;
import com.chinasoft.cto.capitalAccount.utils.DBUtil;




public class NewsDaoImpl implements NewsDao{
	
	@Override
	public List<News> queryNews(News news) {
		StringBuffer sql=new StringBuffer("select * from news where mark=0" );
		List<Object> params=new ArrayList<Object>();
//		if(news.getTitle()!=null && !news.getTitle().equals("")){
//			sql.append(" and title like ?");
//			params.add("%"+news.getTitle()+"%");
//		}
		System.out.println(news.getTitle());
		if(news.getTitle()!=null && !news.getTitle().equals("")){
			sql.append(" and title like ?");
			params.add("%"+news.getTitle()+"%");
		}
		System.out.println(params);
		try {
			return DBUtil.queryAll(News.class, sql.toString(),params.toArray());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateNews(News news) {
		int rows=DBUtil.update("update news set title=?,newsAbstract=?,text=? where newsid=?",
				news.getTitle(),news.getNewsAbstract(),news.getText(),news.getNewsid());;
		if(rows>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteNews(String[] ids) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			int rows=0;
			for (String id : ids) {
				
				rows+=DBUtil.update("delete from news where newsid=?",
						id);;
			}
			if(rows==ids.length){
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}
		}catch (SQLException e) {
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

	@Override
	public boolean addNews(News news) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			QueryRunner qr=new QueryRunner();
//			int rows=qr.update(conn, "insert into news(,loginPwd) values(?,?)", 
//					user.getLoginAccount(),user.getLoginPwd());
//			//查询才添加的那个id
//			BigInteger loginId=qr.query(conn, "select last_insert_id()",new ScalarHandler<BigInteger>());
		
			int rows1=qr.update(conn, "insert into news(title,newsAbstract,text,mark,releaseDate) values(?,?,?,?,now())",
					news.getTitle(),news.getNewsAbstract(),news.getText(),0);;
			
			conn.commit();
			conn.setAutoCommit(true);
			return true;
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
