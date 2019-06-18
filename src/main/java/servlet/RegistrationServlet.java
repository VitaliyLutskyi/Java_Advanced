package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import domain.User;
import domain.UserRole;
import dto.UserDto;
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
			User user = userservice.create(new User(firstName, lastName, age, address, eMail, password, role));
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getId());
			session.setAttribute("role", user.getRole());
			
			String json = new Gson().toJson(new UserDto(firstName, lastName, "index.jsp"));
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		
	}

}
