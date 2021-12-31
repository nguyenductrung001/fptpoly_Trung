package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;
@WebServlet("/admin/users/delete")
public class DeleteServlet extends HttpServlet {
	private UserDAO userDAO;
	public  DeleteServlet() {
		super();
		this.userDAO = new UserDAO();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String idStr = request.getParameter("id");
		if(idStr == null) {
				// 404
		}
		int id = Integer.parseInt(idStr);
		// tạo ra đối tượng User để so sánh 
		User entity = new User();
		// lấy đc id cần xóa 
		entity.setId(id);
		// thực hiện xóa
		this.userDAO.delete(entity);
		// xóa xong sẽ chuyển hướng đến file U
		response.sendRedirect("/PT15304/admin/users");
//		request.setAttribute("user", entity);
//		request.getRequestDispatcher("/admin/users/").forward(request, response);
		
	}

}
