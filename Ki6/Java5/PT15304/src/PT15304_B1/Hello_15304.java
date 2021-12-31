package PT15304_B1;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Hello/index")
public class Hello_15304 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException {
//	res.getWriter().print("<h1>Hello PT15304<h1>");
	String paramsName = req.getParameter("name");
	String name = paramsName == null? "Trung": paramsName;
	System.out.println("----------"+ req.getParameter("name"));
	req.setAttribute("myName", name);
	req.getRequestDispatcher("/views/Buoi2/hello.jsp").forward(req, res);
}
}
