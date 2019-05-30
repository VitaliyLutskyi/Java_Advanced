package service.impl;

import java.sql.SQLException;
import java.util.List;
import dao.BucketDAO;
import dao.impl.BucketDAOImpl;
import domain.Bucket;
import service.BucketService;

public class BucketServiceImpl implements BucketService{
	
	private BucketDAO bucketDAO;

	public BucketServiceImpl() {
		try {
			bucketDAO = new BucketDAOImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		bucketDAO.update(t);
	}

	@Override
	public void delete(int id) {
		bucketDAO.delete(id);
	}

}
