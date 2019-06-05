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

import dao.UserDAO;
import domain.User;
import utils.ConnectionUtils;

public class UserDAOImpl implements UserDAO{
	
	private static String CREATE = "INSERT INTO users (first_name, last_name, age, address, email, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static String READ_BY_ID = "SELECT * FROM users WHERE id = ?";
	private static String READ_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
	private static String READ_ALL = "SELECT * FROM users";
	private static String UPDATE_BY_ID = "UPDATE users SET first_name = ?, last_name = ?, age = ?, address = ?, email = ?, password = ?, role = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	public UserDAOImpl() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		connection = ConnectionUtils.connect();
	}
	
	@Override
	public User create(User user) {
		
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getAge().toString());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.geteMail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getRole());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
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
			
			int userId = result.getInt(1);
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			Integer age = result.getInt("age");
			String address = result.getString("address");
			String eMail = result.getString("email");
			String password = result.getString("password");	
			String role = result.getString("role");
			user = new User(userId, firstName, lastName, age, address, eMail, password, role);
		} catch (SQLException e) {
			LOGGER.error(e);
		}		
		
		return user;
	}
	
	@Override
	public User readByEmail(String eMail) {
		
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, eMail);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			int id = result.getInt(1);
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			Integer age = result.getInt("age");
			String address = result.getString("address");
			String password = result.getString("password");	
			String role = result.getString("role");
			user = new User(id, firstName, lastName, age, address, eMail, password, role);
		} catch (SQLException e) {
			LOGGER.error(e);
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
				Integer age = result.getInt("age");
				String address = result.getString("address");
				String eMail = result.getString("email");
				String password = result.getString("password");	
				String role = result.getString("role");
				listOfUsers.add(new User(id, firstName, lastName, age, address, eMail, password, role));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
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
			preparedStatement.setString(7, user.getRole());
			preparedStatement.setInt(8, user.getId());
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
