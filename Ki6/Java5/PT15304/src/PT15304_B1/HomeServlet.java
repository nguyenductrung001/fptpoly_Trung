package PT15304_B1;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Home/index")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException {
		req.getRequestDispatcher("/views/auth/register.jsp").forward(req, res); 
	}
}
