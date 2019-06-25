package les15.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import les15.utils.HibernateUtil;

public class HbnStarter {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		Post post1 = new Post("Sport post");
		Post post2 = new Post("News post");
		
		Comment comment1 = new Comment("Petro");
		comment1.setPost(post1);
		Comment comment2 = new Comment("Andry");
		comment2.setPost(post2);
		Comment comment3 = new Comment("Slava");
		comment3.setPost(post2);
		Comment comment4 = new Comment("Vitaliy");
		comment4.setPost(post1);

		post1.setComments(new HashSet<Comment>(Arrays.asList(comment1, comment4)));
		post2.setComments(new HashSet<Comment>(Arrays.asList(comment2, comment3)));
		
		session.save(post1);
		session.save(post2);
		transaction.commit();
		
		Post postRead = session.get(Post.class, 1);
		System.out.println("Post#1" + postRead + "comments: " + postRead.getComments());
		
		@SuppressWarnings("unchecked")
		List<Post> posts = session.createQuery("FROM Post").list();
		System.out.println("\nAll posts: ");
		posts.forEach(post -> System.out.println(post.toString()+post.getComments()));
		
	}

}
