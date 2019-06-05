package domain;

public class Magazine {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private int stockQuantity;
	
	public Magazine(int id, String name, String description, double price, int stockQuantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public Magazine(String name, String description, double price, int stockQuantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + "]";
	}
	
}
