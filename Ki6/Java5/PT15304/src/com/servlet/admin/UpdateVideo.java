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
import com.dao.VideoDao;
import com.entity.User;
import com.entity.Video;

@WebServlet("/admin/users/update-video")
public class UpdateVideo extends HttpServlet {
	private VideoDao videoDao;
	public  UpdateVideo() {
		super();
		this.videoDao = new VideoDao();
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
		Video entity = this.videoDao.finById(id);
		request.setAttribute("video", entity);
		request.getRequestDispatcher("/views/admin/users/updateVideo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Video entity = new Video();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 this.videoDao.update(entity);
		 response.sendRedirect(request.getContextPath()+"/admin/danhsach");
		 
	}
	
}
