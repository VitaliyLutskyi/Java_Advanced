package les04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice = UserService.getUserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");

		userservice.saveUser(new User(firstName, lastName, age, address, eMail, password));
		request.setAttribute("firstName", firstName);	
		request.setAttribute("lastName", lastName);
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}
