package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;
    public LoginServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/admin/users/login.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		
		String email = request.getParameter("txtUser"),
			password = request.getParameter("txtPass");
		
		User entity = this.userDAO.login(email, password);
		if (entity == null) {
			response.sendRedirect(
				request.getContextPath() + "/login"
			);
		} else {
			if(entity.getRole()==0) {
				HttpSession session = request.getSession();
				session.setAttribute("auth", entity);
				response.sendRedirect(
					request.getContextPath() + "/UserLayOut"
				);
			}else if(entity.getRole()==1) {
				HttpSession session = request.getSession();
				session.setAttribute("user", entity);
				response.sendRedirect(
					request.getContextPath() + "/admin/users"
				);
			}
			
		}
	}

}
