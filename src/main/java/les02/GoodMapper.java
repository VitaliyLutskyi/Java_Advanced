package les02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodMapper {
	
	public static Good map(ResultSet result) throws SQLException {
		
		int id = result.getInt("id");
		String name = result.getString("name");
		double price = result.getDouble("price");
		int stockQuantity = result.getInt("stock_quantity");
		
		return new Good(id, name, price, stockQuantity);
	}
}
