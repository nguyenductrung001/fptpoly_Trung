package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDao;
import com.entity.Video;

@WebServlet("/User")
public class AdminLayOut extends HttpServlet {
	VideoDao videoDao;
	
	public AdminLayOut() {
		this.videoDao = new VideoDao();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 10 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		List<Video> listVideo = this.videoDao.paginate(offset, limit);

//		TypedQuery<User> query = HibernateUtils.getSession().createNamedQuery("User.getLiActive", User.class);
//		List<User> listUser = query.getResultList();

		request.setAttribute("listVideo", listVideo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/admin/users/layoutAdmin.jsp").forward(request, response);
	}
}
