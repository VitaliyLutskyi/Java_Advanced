package les19.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les19.dao.StudentRepo;
import les19.domain.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public Student readById(String id) throws FileNotFoundException {
		return studentRepo.findById(id).orElseThrow(() -> new FileNotFoundException("There is no student with id = "+ id));
	}

}
