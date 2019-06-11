package dao;

import domain.User;
import shared.AbstractCRUD;

public interface UserDAO extends AbstractCRUD<User>{
	
	User readByEmail(String eMail);
}
