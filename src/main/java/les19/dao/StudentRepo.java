package les19.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import les19.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String>{

}
