package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import dao.BucketDAO;
import domain.Bucket;
import shared.FactoryManager;

public class BucketDAOImpl implements BucketDAO{

	private static EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(BucketDAOImpl.class);

	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return bucket;
	}

	@Override
	public Bucket read(int id) {
		Bucket bucket = null;
		try {
			em.find(Bucket.class, id);
		} catch (Exception e) {
			LOGGER.error(e);
		}		
		
		return bucket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<Bucket>();
		try {
			bucketRecords = em.createQuery("FROM Bucket").getResultList();		
		} catch (Exception e) {
			LOGGER.error(e);
		}	
		
		return bucketRecords;
	}

	@Override
	public void update(Bucket t) {
		throw new IllegalStateException("Update doesn't work for Bucket");
	}

	@Override
	public void delete(int id) {
		try {
			Bucket bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}	
	}

}
