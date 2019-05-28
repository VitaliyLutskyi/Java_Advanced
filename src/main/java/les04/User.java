package les04;

public class User {
	String firstName;
	String lastName;
	int age;
	String address;
	String eMail;
	String password;

	public User(String firstName, String lastName, int age, String address, String eMail, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.eMail = eMail;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", eMail=" + eMail + "]";
	}

	
	
	
}
