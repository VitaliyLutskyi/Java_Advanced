package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.UserDAO;
import domain.User;
import utils.ConnectionUtils;

public class UserDAOImpl implements UserDAO{
	
	private static String CREATE = "INSERT INTO users (first_name, last_name, age, address, email, password) VALUES (?, ?, ?, ?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM users WHERE ID = ?";
	private static String READ_ALL = "SELECT * FROM users";
	private static String UPDATE_BY_ID = "UPDATE users SET first_name = ?, last_name = ?, age = ?, address = ?, email = ?, password = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UserDAOImpl() throws SQLException {
		connection = ConnectionUtils.connect();
	}

	@Override
	public User create(User user) {
		
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.geteMail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User read(int id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			int age = result.getInt("age");
			String address = result.getString("address");
			String eMail = result.getString("email");
			String password = result.getString("password");	
			user = new User(id, firstName, lastName, age, address, eMail, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return user;
	}

	@Override
	public List<User> readAll() {
		List<User> listOfUsers = new ArrayList<User>();
		try {
			ResultSet result = connection.createStatement().executeQuery(READ_ALL);
			while (result.next()) {
				int id = result.getInt(1);
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				int age = result.getInt("age");
				String address = result.getString("address");
				String eMail = result.getString("email");
				String password = result.getString("password");	
				listOfUsers.add(new User(id, firstName, lastName, age, address, eMail, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return listOfUsers;
	}

	@Override
	public void update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.geteMail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
