package les02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO {
	
	private static String CREATE = "INSERT INTO goods (name, price, stock_quantity) VALUES (?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM goods WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM goods";
	private static String UPDATE_BY_ID = "UPDATE goods SET name = ?, price = ?, stock_quantity = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM goods WHERE id = ?";

	private Connection connection;

	public GoodDAO() throws SQLException {
		this.connection = ConnectionUtils.connect();
	}
	
	public void insert(Good good) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, good.getName());
		preparedStatement.setDouble(2, good.getPrice());
		preparedStatement.setInt(3, good.getStockQuantity());
		preparedStatement.executeUpdate();
	}

	public Good read(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return GoodMapper.map(result);
	}

	public List<Good> readAll() throws SQLException {
		List<Good> list = new ArrayList<Good>();
		ResultSet result = connection.createStatement().executeQuery(READ_ALL);
		while (result.next())
			list.add(GoodMapper.map(result));
		return list;
	}

	public void update(Good good) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, good.getName());
		preparedStatement.setDouble(2, good.getPrice());
		preparedStatement.setInt(3, good.getStockQuantity());
		preparedStatement.setInt(4, good.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
}
