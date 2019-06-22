package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import dao.MagazineDAO;
import domain.Magazine;
import shared.FactoryManager;

public class MagazineDAOImpl implements MagazineDAO{
	
	private static EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(MagazineDAOImpl.class);

	@Override
	public Magazine create(Magazine magazine) {
		try {
			em.getTransaction().begin();
			em.persist(magazine);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return magazine;
	}

	@Override
	public Magazine read(int id) {
		Magazine magazine = null;
		try {
			em.find(Magazine.class, id);
		} catch (Exception e) {
			LOGGER.error(e);
		}		
		
		return magazine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Magazine> readAll() {
		List<Magazine> listOfMagazines = new ArrayList<Magazine>();
		try {
			listOfMagazines = em.createQuery("FROM Magazine").getResultList();
			
		} catch (Exception e) {
			LOGGER.error(e);
		}	
		
		return listOfMagazines;
	}

	@Override
	public void update(Magazine magazine) {
		try {
			em.merge(magazine);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			Magazine magazine = read(id);
			em.getTransaction().begin();
			em.remove(magazine);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}	
	}

}
