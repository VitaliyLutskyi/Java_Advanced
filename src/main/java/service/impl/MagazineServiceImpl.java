package service.impl;

import java.sql.SQLException;
import java.util.List;
import dao.MagazineDAO;
import dao.impl.MagazineDAOImpl;
import domain.Magazine;
import service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	
	private MagazineDAO magazineDAO;	
	
	public MagazineServiceImpl() {
		try {
			magazineDAO = new MagazineDAOImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
