package les17.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column
	String name;
	
	@Column(name = "accreditation_level")
	int levelOfAccreditation;
	
	@Column(name = "institutes_number")
	int numberOfInstitutes;
	
	@Column(name = "students_number")
	int numberOfStudents;
	
	@Column
	String address;
	
	public University() {}
	
	public University(String name, int levelOfAccreditation, int numberOfInstitutes, int numberOfStudents,
			String address) {
		this.name = name;
		this.levelOfAccreditation = levelOfAccreditation;
		this.numberOfInstitutes = numberOfInstitutes;
		this.numberOfStudents = numberOfStudents;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevelOfAccreditation() {
		return levelOfAccreditation;
	}

	public void setLevelOfAccreditation(int levelOfAccreditation) {
		this.levelOfAccreditation = levelOfAccreditation;
	}

	public int getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(int numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", levelOfAccreditation=" + levelOfAccreditation
				+ ", numberOfInstitutes=" + numberOfInstitutes + ", numberOfStudents=" + numberOfStudents + ", address="
				+ address + "]";
	}
	
	
}	
