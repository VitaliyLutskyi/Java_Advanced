package les02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierMapper {
	
	public static Supplier map(ResultSet result) throws SQLException {
		
		int id = result.getInt("id");
		String name = result.getString("name");
		String address = result.getString("address");
		String phoneNumber = result.getString("phone_number");
		String eMail = result.getString("email");
		
		return new Supplier(id, name, address, phoneNumber, eMail);
	}
}
