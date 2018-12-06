package com.chinasoft.cto.capitalAccount.model;

public class News {
	
	private int newsid;
	private String title;
	private String newsAbstract;
	private String text;
	private String releaseDate;
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewsAbstract() {
		return newsAbstract;
	}
	public void setNewsAbstract(String newsAbstract) {
		this.newsAbstract = newsAbstract;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public News(int newsid, String title, String newsAbstract, String text, String releaseDate) {
		super();
		this.newsid = newsid;
		this.title = title;
		this.newsAbstract = newsAbstract;
		this.text = text;
		this.releaseDate = releaseDate;
	}
	public News() {
		super();
	}
	
}
