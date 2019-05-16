package les02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {
	
	public static Employee map(ResultSet result) throws SQLException {
		int id;
		String firstName;
		String lastName;
		String phoneNumber;
		String address;
		
		id = result.getInt("id");
		firstName = result.getString("first_name");
		lastName = result.getString("last_name");
		phoneNumber = result.getString("phone_number");
		address = result.getString("address");
		
		
		return new Employee(id, firstName, lastName, phoneNumber, address);
	}
}
