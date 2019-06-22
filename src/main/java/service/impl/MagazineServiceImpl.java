package service.impl;

import java.util.List;

import dao.MagazineDAO;
import dao.impl.MagazineDAOImpl;
import domain.Magazine;
import service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	
	private MagazineDAO magazineDAO;	
	private static MagazineService magazineServiceImpl;
	
	private MagazineServiceImpl() {
			magazineDAO = new MagazineDAOImpl();
	}
	
	public static MagazineService getMagazineService() {
		if(magazineServiceImpl == null)
			magazineServiceImpl = new MagazineServiceImpl();
		return magazineServiceImpl;
	}

	@Override
	public Magazine create(Magazine magazine) {
		return magazineDAO.create(magazine);
	}

	@Override
	public Magazine read(int id) {
		return magazineDAO.read(id);
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDAO.readAll();
	}

	@Override
	public void update(Magazine magazine) {
		magazineDAO.update(magazine);
	}

	@Override
	public void delete(int id) {
		magazineDAO.delete(id);	
	}

}
