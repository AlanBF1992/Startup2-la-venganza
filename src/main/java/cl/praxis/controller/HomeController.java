package cl.praxis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.model.dao.UserDAO;
import cl.praxis.model.dao.UserRolesDAO;
import cl.praxis.model.dao.VehiculoDAO;
import cl.praxis.model.dto.Vehiculo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehiculoDAO vDAO = new VehiculoDAO();
	UserDAO uDAO = new UserDAO();
	UserRolesDAO urDAO = new UserRolesDAO();;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		
		if(session.getAttribute("isLogged") == null || !(boolean)session.getAttribute("isLogged")) {
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}

		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		String correo = (String) session.getAttribute("usermail");
		int userId = uDAO.read(correo).getId();
		List<Integer> roles = urDAO.getRoles(userId);
		
		request.setAttribute("autorizado", false);
				
		if (roles.contains(1)) {
			vehiculos = vDAO.read();
			request.setAttribute("autorizado", true);
		}
		
		request.setAttribute("vehiculos", vehiculos);
		
		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		doGet(request, response);
	}

}
