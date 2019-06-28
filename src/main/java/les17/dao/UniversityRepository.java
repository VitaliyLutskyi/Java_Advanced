package les17.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import les17.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {
	
	List<University> findByName(String name);
	
}
