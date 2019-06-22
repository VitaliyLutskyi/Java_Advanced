package service.impl;

import java.util.List;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	private static UserService userServiceImpl;
	
	private UserServiceImpl() {
			userDAO = new UserDAOImpl();
	}
	
	public static UserService getUserService() {
		if(userServiceImpl == null)
			userServiceImpl = new UserServiceImpl();
		return userServiceImpl;
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
	public User readByEmail(String eMail) {
		return userDAO.readByEmail(eMail);
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
