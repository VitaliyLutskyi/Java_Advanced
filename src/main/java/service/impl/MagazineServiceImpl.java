package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.MagazineDAO;
import dao.impl.MagazineDAOImpl;
import domain.Magazine;
import service.MagazineService;

public class MagazineServiceImpl implements MagazineService{
	
	private static Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
	
	private MagazineDAO magazineDAO;	
	private static MagazineService magazineServiceImpl;
	
	private MagazineServiceImpl() {
		try {
			magazineDAO = new MagazineDAOImpl();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
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
