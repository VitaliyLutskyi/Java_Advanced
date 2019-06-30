package les18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import les18.dao.impl.ParticipantRepoImpl;
import les18.entity.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	ParticipantRepoImpl participantRepo;
	
	public void save(Participant participant) {
		participantRepo.save(participant);
	}
	public Participant read(int id) {
		return participantRepo.read(id);
	}
	public List<Participant> readAll(){
		return participantRepo.readAll();
	}
	public void update(Participant participant) {
		participantRepo.update(participant);
	}
	public void delete(int id) {
		participantRepo.delete(id);
	}
}
