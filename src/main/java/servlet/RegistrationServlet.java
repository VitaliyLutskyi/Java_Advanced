package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.UserRole;
import service.UserService;
import service.impl.UserServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userservice = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer age = null;
		if(!request.getParameter("age").isEmpty())
			age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("password");
		String role = UserRole.USER.toString();

		if (!firstName.isEmpty() && !lastName.isEmpty() && !eMail.isEmpty() && !password.isEmpty() && !role.isEmpty() && age != null) {
			userservice.create(new User(firstName, lastName, age, address, eMail, password, role));
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("You are registered!");
		}
		else
			request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

}
