package les04;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> listOfUsers = new ArrayList<User>();
	private static UserService userService;
	
	private UserService() {}
	
	public static UserService getUserService() {
		if(userService == null)
			userService = new UserService();
		return userService;
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}
	
	public void saveUser(User user) {
		listOfUsers.add(user);
	}
	
	public User getUser(String eMail) {
		return listOfUsers.stream().filter(user->user.geteMail().equalsIgnoreCase(eMail)).findAny().orElse(null);
	}
}
