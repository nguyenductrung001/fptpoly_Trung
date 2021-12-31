package com.servlet.admin;

import java.io.IOException;

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

@WebServlet("/themmoi")
public class themmoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDao videoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themmoi() {
        super();
        this.videoDao = new VideoDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/views/admin/users/themvideo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video entity = new Video();
		try {
			BeanUtils.populate(
					entity, 
					request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.videoDao.store(entity);
		doGet(request, response);
	}
	@Override
	public void init() throws ServletException{
		System.out.println("Init.....");
		super.init();
	}
	@Override
	public void destroy() {
		System.out.println("Destroy......");
		super.destroy();
	}
	@Override public void service(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException,IOException{
		System.out.println("Processing");
		super.service(request, response);
	}

}