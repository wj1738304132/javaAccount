package com.chinasoft.cto.capitalAccount.untils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 查询任何对象的工具类
 * @author Administrator
 *
 */
public class DBUtil {
	private static ComboPooledDataSource dataSource=null;
	private static 	QueryRunner qr=null;
	static{
		dataSource=new ComboPooledDataSource();
		qr=new QueryRunner(dataSource);
	}
	private DBUtil(){}
	
	public static DataSource getDbUtil(){
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException{
			Connection conn=dataSource.getConnection();
			conn.setAutoCommit(false);
			return conn;

	}
	
	/**
	 * 通用的更新数据方法
	 * @param sql 更新sql语句
	 * @param params 更新sql的条件
	 * @return
	 */
	public static int update(String sql,Object...params){
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static int update(Connection conn,String sql,Object...params){
		try {
			return qr.update(conn,sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void rollBack(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public static void commit(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void autoCommit(Connection conn,Boolean isAutoCommit){
		try {
			conn.setAutoCommit(isAutoCommit);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通用的查询一个对象的方法
	 * @param t 查询的对象class类型
	 * @param sql 查询sql
	 * @param params 查询参数
	 * @return
	 * @throws Exception
	 */
	public static <T>T queryOne(Class<T> t,String sql,Object...params) throws Exception{
		T bean=qr.query(sql, new BeanHandler<T>(t), params);
		return bean;
	}
	/**
	 * 通用的查询多个对象的方法
	 * @param t 查询的对象class类型
	 * @param sql 查询sql
	 * @param params 查询参数
	 * @return
	 * @throws Exception
	 */
	public static <T>List<T> queryAll(Class<T> t,String sql,Object...params) throws Exception{
		List<T> list=qr.query(sql, new BeanListHandler<T>(t), params);
		return list;
	}
	/**
	 * 通用的查询数值型方法
	 * @param t
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static <T>T queryNumber(Class<T> t,String sql,Object...params) throws Exception{
		T nums=qr.query(sql, new ScalarHandler<T>(), params);
		return nums;
	}
}
