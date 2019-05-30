package domain;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String eMail;
	private String password;
	
	public User(int id, String firstName, String lastName, int age, String address, String eMail, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.eMail = eMail;
		this.password = password;
	}

	public User(String firstName, String lastName, int age, String address, String eMail, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.eMail = eMail;
		this.password = password;
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

	public int getAge() {
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
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address="
				+ address + ", eMail=" + eMail + ", password=" + password + "]";
	}

}
