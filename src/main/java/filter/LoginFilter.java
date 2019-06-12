package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import shared.FilterService;

// USER and ADMIN don't have access, must logout first
@WebFilter({"/login.jsp", "/registration.jsp"})
public class LoginFilter implements Filter {
private FilterService filterService = FilterService.getFilterService();
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filterService.notLoggedInFilterValidation(request, response, chain);	
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
