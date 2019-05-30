package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.BucketDAO;
import domain.Bucket;
import utils.ConnectionUtils;

public class BucketDAOImpl implements BucketDAO{
	
	private static String CREATE = "INSERT INTO bucket (user_id, magazine_id, purchase_date) VALUES (?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM bucket WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM bucket";
	private static String DELETE_BY_ID = "DELETE FROM bucket WHERE id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public BucketDAOImpl() throws SQLException {
		connection = ConnectionUtils.connect();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getMagazineId());
			preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			bucket.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bucket;
	}

	@Override
	public Bucket read(int id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			int userId = result.getInt("user_id");
			int magazineId = result.getInt("magazine_id");
			Date purchaseDate = result.getDate("purchase_date");
			bucket = new Bucket(id, userId, magazineId, purchaseDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return bucket;
	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<Bucket>();
		try {
			ResultSet result = connection.createStatement().executeQuery(READ_ALL);
			while (result.next()) {
				int id = result.getInt(1);
				int userId = result.getInt("user_id");
				int magazineId = result.getInt("magazine_id");
				Date purchaseDate = result.getDate("purchase_date");
				bucketRecords.add(new Bucket(id, userId, magazineId, purchaseDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
