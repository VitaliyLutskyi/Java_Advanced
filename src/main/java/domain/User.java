package domain;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String address;
	private String eMail;
	private String password;
	private String role;
	
	public User(int id, String firstName, String lastName, Integer age, String address, String eMail, String password, String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.eMail = eMail;
		this.password = password;
		this.role = role;
	}

	public User(String firstName, String lastName, Integer age, String address, String eMail, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.eMail = eMail;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String geteMail() {
		return eMail;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + ", eMail=" + eMail + ", password=" + password + ", role=" + role + "]";
	}

}
