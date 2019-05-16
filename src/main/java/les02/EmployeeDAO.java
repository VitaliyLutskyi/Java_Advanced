package les02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private static String CREATE = "INSERT INTO employees (first_name, last_name, phone_number, address) VALUES (?, ?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM employees WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM employees";
	private static String UPDATE_BY_ID = "UPDATE employees SET first_name = ?, last_name = ?, phone_number = ?, address = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM employees WHERE id = ?";

	private Connection connection;

	public EmployeeDAO() throws SQLException {
		this.connection = ConnectionUtils.connect();
	}

	public void insert(Employee employee) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getPhoneNumber());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.executeUpdate();
	}

	public Employee read(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return EmployeeMapper.map(result);
	}

	public List<Employee> readAll() throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		ResultSet result = connection.createStatement().executeQuery(READ_ALL);
		while (result.next())
			list.add(EmployeeMapper.map(result));
		return list;
	}

	public void update(Employee employee) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, employee.getFirstName());
		preparedStatement.setString(2, employee.getLastName());
		preparedStatement.setString(3, employee.getPhoneNumber());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setInt(5, employee.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
}
