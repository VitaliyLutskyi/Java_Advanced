package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Bucket;
import service.BucketService;
import service.impl.BucketServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bucketService = BucketServiceImpl.getBucketService();
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer magazineId = Integer.parseInt( request.getParameter("magazineId"));
		Integer userId =  (Integer) request.getSession().getAttribute("userId");
		
		bucketService.create(new Bucket(userId, magazineId, new Date()));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("ok");
	}

}
