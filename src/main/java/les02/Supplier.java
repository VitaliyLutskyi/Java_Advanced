package les02;

public class Supplier {
	int id;
	String name;
	String address;
	String phoneNumber;
	String eMail;
	
	public Supplier(String name, String address, String phoneNumber, String eMail) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public Supplier(int id, String name, String address, String phoneNumber, String eMail) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", eMail=" + eMail + "]";
	}
	
	
}
