package com.gzmu.interManSys.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CharacterEncodingFilter extends HttpServlet implements Filter { //继承Filter
  
	private static final long serialVersionUID = 1L;
	//初始化
    protected String encoding=null;
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if(encoding!=null){
        //设置编码 
            request.setCharacterEncoding(encoding);
         //设置页面编码
            response.setContentType("text/html;charset="+encoding); 
            response.setCharacterEncoding(encoding);  
        }
     //传到下一个过滤器
        chain.doFilter(request, response);

    }
 
    public void init(FilterConfig filterConfig) throws ServletException {
      //编码过滤器的初始化
        encoding=filterConfig.getInitParameter("encoding");

    }

    public void destroy() {
       encoding=null;
    }
}
