package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.model.dao.UserDAO;
import cl.praxis.model.dto.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO uDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String logoff = request.getParameter("logoff");
		
		if (logoff != null && logoff.equalsIgnoreCase("1")) {
			session.setAttribute("username", "");
			session.setAttribute("usermail", "");
			session.setAttribute("isLogged", false);
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}
		
		if(session.getAttribute("isLogged") != null && (boolean)session.getAttribute("isLogged")) {
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		
		User u = null;
		
		if (password != null && !password.isBlank() && correo != null && !correo.isBlank()) {
			u =  uDAO.read(correo, password);
		}
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", u.getNombre());
			session.setAttribute("usermail", u.getCorreo());
			session.setAttribute("isLogged", true);
		}
		doGet(request, response);
	}

}
