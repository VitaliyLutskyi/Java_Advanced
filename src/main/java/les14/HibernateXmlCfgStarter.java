package les14;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateXmlCfgStarter {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Item item1 = new Item("First item");
		Item item2 = new Item("Second item");
		Item item3 = new Item("Third item");
		Item item4 = new Item("Fourth item");
			
		Cart cart = new Cart(4, "newCart");
		cart.setItems(new HashSet<Item>(Arrays.asList(item1, item2, item3, item4)));
		session.save(cart);
		transaction.commit();
	}

}
