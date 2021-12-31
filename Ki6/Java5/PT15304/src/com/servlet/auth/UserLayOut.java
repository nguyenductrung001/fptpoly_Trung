package com.servlet.auth;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDao;
import com.entity.Video;
import com.utils.HibernateUtils;

@WebServlet("/UserLayOut")
public class UserLayOut extends HttpServlet {
	VideoDao videoDao;
	
	public UserLayOut() {
		this.videoDao = new VideoDao();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 10 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		List<Video> listVideos = this.videoDao.paginate(offset, limit);

		TypedQuery<Video> query = HibernateUtils.getSession().createNamedQuery("Video.getListActive", Video.class);
		List<Video> listVideo = query.getResultList();
		request.setAttribute("listVideo", listVideos);
		request.setAttribute("listVideo", listVideo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/admin/users/layoutUser.jsp").forward(request, response);
	}
}
