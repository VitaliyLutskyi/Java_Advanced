package les02;

public class Good {
	int id;
	String name;
	double price;
	int stockQuantity;
	
	public Good(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public Good(int id, String name, double price, int stockQuantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}
	
	
}
