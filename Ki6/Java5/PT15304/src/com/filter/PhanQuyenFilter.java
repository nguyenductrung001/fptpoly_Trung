package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;


@WebFilter({"/admin/users","/User","/themmoi","/admin/users","/admin/danhsach"})
public class PhanQuyenFilter implements Filter {

    public PhanQuyenFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request,
			             ServletResponse response, 
			              FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		User user = (User) httpRequest.getSession().getAttribute("user");
		if(user == null) {
			HttpServletResponse httResponse = (HttpServletResponse) response;
			httResponse.sendRedirect(
					httpRequest.getContextPath() + "/login"
					);
		}else {
			chain.doFilter(request, response);
		}
		

	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
