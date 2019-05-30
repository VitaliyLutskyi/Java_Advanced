package service.impl;

import java.sql.SQLException;
import java.util.List;
import dao.UserDAO;
import dao.impl.UserDAOImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	public UserServiceImpl() {
		try {
			userDAO = new UserDAOImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User create(User user) {
		return userDAO.create(user);
	}

	@Override
	public User read(int id) {
		return userDAO.read(id);
	}

	@Override
	public List<User> readAll() {
		return userDAO.readAll();
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
		
	}

}
