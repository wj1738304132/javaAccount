package com.chinasoft.cto.capitalAccount.dao;

import java.util.List;

import com.chinasoft.cto.capitalAccount.model.News;



public interface NewsDao {
	
	

	public List<News> queryNews(News news);

	public boolean addNews(News news);

	public boolean updateNews(News news);

	public boolean deleteNews(String[] ids);



}
