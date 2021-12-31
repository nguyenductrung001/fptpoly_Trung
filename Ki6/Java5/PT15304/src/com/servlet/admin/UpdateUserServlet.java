package com.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/admin/users/update")
public class UpdateUserServlet extends HttpServlet {
	private UserDAO userDAO;
	public  UpdateUserServlet() {
		super();
		this.userDAO = new UserDAO();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//		User entity = new User();
//		try {
//			BeanUtils.populate(entity, request.getParameterMap());
//		 catch (InvocationTargetException e) {
//			
//			e.printStackTrace();
//		}
//		 this.userDAO.update(entity);
//		 response.sendRedirect(request.getContextPath()+"/admin/users");
		 
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.findById(id);
		request.setAttribute("user", entity);
		request.getRequestDispatcher("/views/admin/users/update.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setStatus(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 this.userDAO.update(entity);
		 response.sendRedirect(request.getContextPath()+"/admin/users");
		 
	}
	
}
