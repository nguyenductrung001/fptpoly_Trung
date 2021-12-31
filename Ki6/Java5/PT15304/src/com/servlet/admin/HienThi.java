package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.VideoDao;
import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;

@WebServlet("/admin/danhsach")
public class HienThi extends HttpServlet {
	private VideoDao videoDao;

	public HienThi() {
		this.videoDao = new VideoDao();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		if(page <1) {
			page = 1;
		}
		int limit = limitStr == null ? 10 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		List<Video> listVideo = this.videoDao.paginate(offset, limit);

//		TypedQuery<Video> query = HibernateUtils.getSession().createNamedQuery("Video.getListActive", Video.class);
//		List<Video> listVideo = query.getResultList();
//		request.setAttribute("listVideo", listVideos);
		request.setAttribute("listVideo", listVideo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/admin/users/QuanLyVideo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
		doGet(request, response);
	}
}

