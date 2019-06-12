package filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import domain.UserRole;
import shared.FilterService;

@WebFilter({"/bucket.jsp", "/bucket"})
public class BucketFilter implements Filter {
	private FilterService filterService = FilterService.getFilterService();
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER));
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
