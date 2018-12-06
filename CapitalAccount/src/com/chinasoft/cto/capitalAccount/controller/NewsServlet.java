package com.chinasoft.cto.capitalAccount.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.cto.capitalAccount.dao.NewsDao;
import com.chinasoft.cto.capitalAccount.impl.NewsDaoImpl;
import com.chinasoft.cto.capitalAccount.model.News;
import com.chinasoft.cto.capitalAccount.utils.BaseServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/newsServlet")
public class NewsServlet extends BaseServlet{
	NewsDao newsDao=new NewsDaoImpl();
	
	@Override
	protected void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("默认执行该方法。。。");
	}
	
	public void queryNews(HttpServletRequest req,HttpServletResponse resp){
		String newsid=req.getParameter("newsid");
		String title=req.getParameter("title1");
		String newsAbstract=req.getParameter("newsAbstract");
		String text=req.getParameter("text");
		
		News news=new News();
		news.setNewsAbstract(newsAbstract);
		news.setTitle(title);
		news.setText(text);
				
		List<News> news1=newsDao.queryNews(news);
		
		
		JSONObject json=new JSONObject();
		//easyui的返回数据key必须rows
		json.put("rows", JSONArray.fromObject(news1));
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void addNews(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("utf-8");
//		String newsid=req.getParameter("newsid");
		String title=req.getParameter("title");
//		User user=new User(loginAccount,loginPwd);
	

		String newsAbstract=req.getParameter("newsAbstract");
		String text=req.getParameter("text");
//		String releaseDate=req.getParameter("releaseDate");
//		String userType=req.getParameter("userType")IDCard(IDCard);
		News news=new News();
		news.setNewsAbstract(newsAbstract);
		news.setTitle(title);
		news.setText(text);
		boolean flag=newsDao.addNews(news);		
		System.out.println(title);
		System.out.println(newsAbstract);
		System.out.println(text);
		JSONObject obj=new JSONObject();		
		if(flag){
			obj.put("state", true);
			obj.put("tip", "添加成功");			
		}else{
			obj.put("state", false);
			obj.put("tip", "添加失败");
			
		}
		PrintWriter out=resp.getWriter();
		out.print(obj);
		out.flush();
		out.close();
	}

public void deleteNews(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	String[] ids=req.getParameter("newsid").split(",");
	boolean flag=newsDao.deleteNews(ids);
	System.out.println(flag);
	JSONObject obj=new JSONObject();		
	if(flag){
		obj.put("state", true);
		obj.put("tip", "删除成功");			
	}else{
		obj.put("state", false);
		obj.put("tip", "删除失败");
		
	}
	PrintWriter out=resp.getWriter();
	out.print(obj);
	out.flush();
	out.close();
}

public void updateNews(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	
	String newsid=req.getParameter("newsid");
	String title=req.getParameter("title");
	String newsAbstract=req.getParameter("newsAbstract");
	String text=req.getParameter("text");
	
	News news=new News();
	news.setNewsAbstract(newsAbstract);
	news.setTitle(title);
	news.setText(text);
	news.setNewsid(Integer.valueOf(newsid));
	
		
	boolean flag=newsDao.updateNews(news);
	JSONObject obj=new JSONObject();		
	if(flag){
		obj.put("state", true);
		obj.put("tip", "修改成功");			
	}else{
		obj.put("state", false);
		obj.put("tip", "修改失败");
		
	}
	PrintWriter out=resp.getWriter();
	out.print(obj);
	out.flush();
	out.close();
}

}
