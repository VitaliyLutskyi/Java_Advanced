package service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import dao.BucketDAO;
import dao.impl.BucketDAOImpl;
import domain.Bucket;
import service.BucketService;

public class BucketServiceImpl implements BucketService{
	
	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	
	private BucketDAO bucketDAO;
	private static BucketService bucketServiceImpl;
	
	private BucketServiceImpl() {
		try {
			bucketDAO = new BucketDAOImpl();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	
	public static BucketService getBucketService() {
		if(bucketServiceImpl == null)
			bucketServiceImpl = new BucketServiceImpl();
		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket bucket) {
		return bucketDAO.create(bucket);
	}

	@Override
	public Bucket read(int id) {
		return bucketDAO.read(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDAO.readAll();
	}

	@Override
	public void update(Bucket t) {
		try {
			bucketDAO.update(t);
		} catch (IllegalStateException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void delete(int id) {
		bucketDAO.delete(id);
	}

}
