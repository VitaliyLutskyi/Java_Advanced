package les17.service;

import java.util.List;

import les17.entity.University;

public interface UniversityService {
	
	University save(University university);
	University findById(long id);
	List<University> findAll();
	List<University> findByName(String name);
	University update(University unversity);
	void deleteById(long id);
	
}
