package les18.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import les18.dao.ParticipantRepository;
import les18.entity.Participant;
import les18.entity.ParticipantLevel;

@Repository
public class ParticipantRepoImpl implements ParticipantRepository{

	List<Participant> participants = new ArrayList<Participant>();

	@PostConstruct
	public void init() {

		Participant part1 = new Participant(1, "Oleg", "oleg@i.ua", ParticipantLevel.L2, "html, CSS");
		Participant part2 = new Participant(2, "Igor", "igor@meta.ua", ParticipantLevel.L4,
				"html, CSS, JS, JQuery, Java Core");
		Participant part3 = new Participant(3, "Orest", "orest@i.ua", ParticipantLevel.L1, "html");

		participants.addAll(Arrays.asList(part1, part2, part3));
	}

	@Override
	public void save(Participant participant) {
		if(participant.getId() == null)
			participant.setId(participants.size() + 1);
		participants.add(participant);
		
	}

	@Override
	public Participant read(int id) {
		return participants.stream().filter(part->part.getId() == id).findFirst().orElse(null);
	}

	@Override
	public List<Participant> readAll() {
		return participants;
	}

	@Override
	public void update(Participant participant) {
		Participant oldParticipant = participants.stream().filter(part->part.getId() == participant.getId()).findFirst().get();
		participants.set(participants.indexOf(oldParticipant), participant);
		
	}

	@Override
	public void delete(int id) {
		participants.remove(participants.stream().filter(part->part.getId() == id).findFirst().get());
		for(int i = 0; i<participants.size(); i++)
			participants.get(i).setId(i+1);
	}
}
