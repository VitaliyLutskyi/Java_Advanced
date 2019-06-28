package les17.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les17.dao.UniversityRepository;
import les17.entity.University;
import les17.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	private UniversityRepository universityRepository;
	
	@Override
	public University save(University university) {
		universityRepository.save(university);
		return null;
	}

	@Override
	public University findById(long id) {
		return universityRepository.findById(id).orElse(null);
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

	@Override
	public List<University> findByName(String name) {
		return universityRepository.findByName(name);
	}

	@Override
	public University update(University university) {
		return universityRepository.saveAndFlush(university);
	}

	@Override
	public void deleteById(long id) {
		universityRepository.deleteById(id);
	}
	
}
