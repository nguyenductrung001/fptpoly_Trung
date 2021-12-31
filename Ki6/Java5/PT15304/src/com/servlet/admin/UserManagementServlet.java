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
import com.entity.User;
import com.utils.HibernateUtils;

@WebServlet("/admin/users")
public class UserManagementServlet extends HttpServlet {
	private UserDAO userDAO;

	public UserManagementServlet() {
		this.userDAO = new UserDAO(); 
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String limitStr = request.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 10 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		List<User> listUser = this.userDAO.paginate(offset, limit);
//               dau,
//		TypedQuery<User> query = HibernateUtils.getSession().createNamedQuery("User.getLiActive", User.class);
//		List<User> listUser = query.getResultList();

		request.setAttribute("listUser", listUser);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/admin/users/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
		doGet(request, response);
	}
}
