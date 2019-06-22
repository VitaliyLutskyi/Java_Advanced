package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import dao.UserDAO;
import domain.User;
import shared.FactoryManager;

public class UserDAOImpl implements UserDAO{
	
	private static EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public User create(User user) {
		
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return user;
	}

	@Override
	public User read(int id) {
		User user = null;
		try {
			em.find(User.class, id);
		} catch (Exception e) {
			LOGGER.error(e);
		}		
		
		return user;
	}
	
	@Override
	public User readByEmail(String eMail) {
		
		User user = null;
		try {
				//			*Code from lesson
				//			CriteriaBuilder builder = em.getCriteriaBuilder();
				//			CriteriaQuery<User> criteria = builder.createQuery(User.class);
				//			Root<User> from = criteria.from(User.class);
				//			criteria.select(from);
				//			criteria.where(builder.equal(from.get("email"), eMail));
				//			TypedQuery<User> typed = em.createQuery(criteria);
				//			user = typed.getSingleResult();
			user = (User) em.createQuery("FROM User WHERE email = :email").setParameter("email", eMail).getSingleResult();
		} catch (Exception e) {
			LOGGER.error(e);
		}		
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAll() {
		List<User> listOfUsers = new ArrayList<User>();
		try {
			listOfUsers = em.createQuery("FROM User").getResultList();
			
		} catch (Exception e) {
			LOGGER.error(e);
		}	
		
		return listOfUsers;
	}

	@Override
	public void update(User user) {
		try {
			em.merge(user);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Override
	public void delete(int id) {
		try {
			User user = read(id);
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}	
	}

}
