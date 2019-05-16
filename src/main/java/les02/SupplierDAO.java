package les02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

	private static String CREATE = "INSERT INTO suppliers (name, address, phone_number, email) VALUES (?, ?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM suppliers WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM suppliers";
	private static String UPDATE_BY_ID = "UPDATE suppliers SET name = ?, address = ?, phone_number = ?, email = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM suppliers WHERE id = ?";

	private Connection connection;

	public SupplierDAO() throws SQLException {
		this.connection = ConnectionUtils.connect();
	}
	
	public void insert(Supplier supplier) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, supplier.getName());
		preparedStatement.setString(2, supplier.getAddress());
		preparedStatement.setString(3, supplier.getPhoneNumber());
		preparedStatement.setString(4, supplier.geteMail());
		preparedStatement.executeUpdate();
	}

	public Supplier read(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return SupplierMapper.map(result);
	}

	public List<Supplier> readAll() throws SQLException {
		List<Supplier> list = new ArrayList<Supplier>();
		ResultSet result = connection.createStatement().executeQuery(READ_ALL);
		while (result.next())
			list.add(SupplierMapper.map(result));
		return list;
	}

	public void update(Supplier supplier) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, supplier.getName());
		preparedStatement.setString(2, supplier.getAddress());
		preparedStatement.setString(3, supplier.getPhoneNumber());
		preparedStatement.setString(4, supplier.geteMail());
		preparedStatement.setInt(5, supplier.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
}
