package dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.MagazineDAO;
import domain.Magazine;
import utils.ConnectionUtils;

public class MagazineDAOImpl implements MagazineDAO{
	
	private static String CREATE = "INSERT INTO magazines (name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM magazines WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM magazines";
	private static String UPDATE_BY_ID = "UPDATE magazines SET name = ?, description = ?, price = ?, stock_quantity = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM magazines WHERE id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private static Logger LOGGER = Logger.getLogger(MagazineDAOImpl.class);

	public MagazineDAOImpl() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		connection = ConnectionUtils.connect();
	}

	@Override
	public Magazine create(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getDescription());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.setInt(4, magazine.getStockQuantity());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			magazine.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		return magazine;
	}

	@Override
	public Magazine read(int id) {
		Magazine magazine = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			String name = result.getString("name");
			String description = result.getString("description");
			double price = result.getDouble("price");
			int stockQuantity = result.getInt("stock_quantity");
			magazine = new Magazine(id, name, description, price, stockQuantity);
		} catch (SQLException e) {
			LOGGER.error(e);
		}		
		
		return magazine;
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> listOfMagazines = new ArrayList<Magazine>();
		try {
			ResultSet result = connection.createStatement().executeQuery(READ_ALL);
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString("name");
				String description = result.getString("description");
				double price = result.getDouble("price");
				int stockQuantity = result.getInt("stock_quantity");
				listOfMagazines.add(new Magazine(id, name, description, price, stockQuantity));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}	
		
		return listOfMagazines;
	}

	@Override
	public void update(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getDescription());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.setInt(4, magazine.getStockQuantity());
			preparedStatement.setInt(5, magazine.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}	
	}

}
