package les18.dao;

import java.util.List;

import les18.entity.Participant;

public interface ParticipantRepository {

	public void save(Participant participant);
	public Participant read(int id);
	public List<Participant> readAll();
	public void update(Participant participant);
	public void delete(int id);
}
