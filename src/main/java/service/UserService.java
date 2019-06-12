package service;

import domain.User;
import shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User readByEmail(String eMail);
}
