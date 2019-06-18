package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Bucket;
import domain.Magazine;
import dto.BucketDto;

import service.BucketService;
import service.MagazineService;
import service.impl.BucketServiceImpl;
import service.impl.MagazineServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer magazineId = Integer.parseInt( request.getParameter("magazineId"));
		Integer userId =  (Integer) request.getSession().getAttribute("userId");
		
		bucketService.create(new Bucket(userId, magazineId, new Date()));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("ok");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		List<Bucket> bucketList = bucketService.readAll().stream().filter(bucket -> bucket.getUserId() == userId).collect(Collectors.toList());
		
		String json = new Gson().toJson(map(bucketList));
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("bucketId"));
		bucketService.delete(id);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("ok");
	}
	
	private List<BucketDto> map(List<Bucket> bucketList){
		
		return bucketList.stream().map(bucket -> {
			Magazine magazine = magazineService.read(bucket.getMagazineId());
			BucketDto bucketDto = new BucketDto();
			
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate();
			bucketDto.name = magazine.getName();
			bucketDto.description = magazine.getDescription();
			bucketDto.price = magazine.getPrice();
			return bucketDto;
		}).collect(Collectors.toList());
	}
}













