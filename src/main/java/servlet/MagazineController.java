package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Magazine;
import service.MagazineService;
import service.impl.MagazineServiceImpl;

@WebServlet("/magazine")
public class MagazineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
    
    // create magazine
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Double price = request.getParameter("price").isEmpty() ? null : Double.parseDouble(request.getParameter("price"));
		Integer stockQuantity = request.getParameter("stock_quantity").isEmpty() ? null : Integer.parseInt(request.getParameter("stock_quantity"));
		
		if (!name.isEmpty() && !description.isEmpty() && (price != null) && (stockQuantity != null)) {
			magazineService.create(new Magazine(name, description, price, stockQuantity));
			
			response.setContentType("text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("index.jsp");
		}
	}
	
	// read magazine
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Magazine magazine = magazineService.read(id);
		request.setAttribute("magazine", magazine);
		request.getRequestDispatcher("singleMagazine.jsp").forward(request, response);
	}
	
	// update magazine
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	// delete magazine
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
