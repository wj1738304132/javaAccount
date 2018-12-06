package com.chinasoft.cto.capitalAccount.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.cto.capitalAccount.model.wj.Admin;
/**
 * 后台登录过滤器
 * @author Administrator
 *
 */
@WebFilter("/*")
public class AdminLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("调用了初始化。。。");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("调用了过滤器。。。");
		//判断用户是否登录，如果登录了就继续执行，否则就执行登录
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		//获取用户的请求地址
		String uri=req.getRequestURI();
		System.out.println(uri);		
		if(admin!=null){
			chain.doFilter(request, response);
		}else if(uri.contains("/adminLogin")){
			chain.doFilter(request, response);
		}else if (uri.contains("/userLogin")) {
			chain.doFilter(request, response);
		}else if (uri.contains("/UserLogin.jsp")) {
			chain.doFilter(request, response);
		}else if(uri.contains("/AdminLogin.jsp")){
			chain.doFilter(request, response);
		}else if(uri.contains("/resources")){
			chain.doFilter(request, response);
		}else{
			req.setAttribute("tip", "请先登录");
			req.getRequestDispatcher("/loginUser.jsp").forward(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("摧毁了filter。。。");
		
	}

}
