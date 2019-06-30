package les18.entity;

public class Participant {
	
	Integer id;
	String name;
	String email;
	ParticipantLevel level;
	String primarySkill;
	
	public Participant(Integer id, String name, String email, ParticipantLevel level, String primarySkill) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.level = level;
		this.primarySkill = primarySkill;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ParticipantLevel getLevel() {
		return level;
	}

	public void setLevel(ParticipantLevel level) {
		this.level = level;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primarySkill == null) ? 0 : primarySkill.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primarySkill == null) {
			if (other.primarySkill != null)
				return false;
		} else if (!primarySkill.equals(other.primarySkill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", email=" + email + ", level=" + level + ", primarySkill="
				+ primarySkill + "]";
	}
	
	
}
