package com.gzmu.interManSys.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CharacterEncodingFilter extends HttpServlet implements Filter { //�̳�Filter
  
	private static final long serialVersionUID = 1L;
	//��ʼ��
    protected String encoding=null;
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if(encoding!=null){
        //���ñ��� 
            request.setCharacterEncoding(encoding);
         //����ҳ�����
            response.setContentType("text/html;charset="+encoding); 
            response.setCharacterEncoding(encoding);  
        }
     //������һ��������
        chain.doFilter(request, response);

    }
 
    public void init(FilterConfig filterConfig) throws ServletException {
      //����������ĳ�ʼ��
        encoding=filterConfig.getInitParameter("encoding");

    }

    public void destroy() {
       encoding=null;
    }
}
