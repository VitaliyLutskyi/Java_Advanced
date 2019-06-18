package shared;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.UserRole;

public class FilterService {
	
	private static FilterService filterService;
	
	private FilterService() {};
	
	public static FilterService getFilterService() {
		if(filterService == null)
			filterService = new FilterService();
		return filterService;
	}
	
	// Filters roles who have access
	public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain,
			List<UserRole> userRole) throws ServletException, IOException {

		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			UserRole role = UserRole.valueOf((String) session.getAttribute("role"));

			if (role != null && userRole.contains(role)) {
				chain.doFilter(request, response);
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
	
	// Filters roles who don't have access
	public void notLoggedInFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{

		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			String role = (String) session.getAttribute("role");
			if (role == null)
				chain.doFilter(request, response);
			else 
				request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
	
	public void loggedInFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{

		try {
			HttpSession session = ((HttpServletRequest) request).getSession();
			String role = (String) session.getAttribute("role");
			if (role != null)
				chain.doFilter(request, response);
			else 
				request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}
}
