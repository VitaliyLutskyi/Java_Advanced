package les20.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les20.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	public User findByUserName(String userName);
}
