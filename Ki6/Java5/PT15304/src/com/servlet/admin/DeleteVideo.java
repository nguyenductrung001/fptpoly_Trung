package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.VideoDao;
import com.entity.User;
import com.entity.Video;
@WebServlet("/admin/deleteVideo")
public class DeleteVideo extends HttpServlet {
private VideoDao videoDao;
public  DeleteVideo() {
	super();
	this.videoDao = new VideoDao();
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	String idStr = request.getParameter("id");
	if(idStr == null) {
			// 404
		
	}
	int id = Integer.parseInt(idStr);
	Video entity = new Video();
	entity.setId(id);
	this.videoDao.delete(entity);
	response.sendRedirect("/PT15304/admin/danhsach");
//	request.setAttribute("user", entity);
//	request.getRequestDispatcher("/admin/users/").forward(request, response);
	
}
}
