package cl.praxis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.praxis.model.dao.UserDAO;
import cl.praxis.model.dto.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO uDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); // Pinche Tomcat
		
		String nombre = request.getParameter("nombre");
		String nick = request.getParameter("nick");
		String password = request.getParameter("password");
		String correo = request.getParameter("correo");
		String peso = request.getParameter("peso");
		
		boolean exito = false;
				
		if (nombre != null && nick != null && password != null && correo != null && peso != null
				 && !nombre.isBlank() && !nick.isBlank() && !password.isBlank() && !correo.isBlank()
				&& !peso.isBlank()) {
			exito = uDAO.create(new User(
					correo,
					nombre,
					nick,
					password,
					peso
					));
		}
		
		request.setAttribute("added", exito);
		doGet(request, response);
	}

}
