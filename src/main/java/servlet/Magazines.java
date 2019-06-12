package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Magazine;
import service.MagazineService;
import service.impl.MagazineServiceImpl;

@WebServlet("/magazines")
public class Magazines extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Magazine> listOfMagazines = magazineService.readAll();
		String json = new Gson().toJson(listOfMagazines);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
