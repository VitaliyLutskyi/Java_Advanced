package domain;

import java.util.Date;

public class Bucket {
	
	private int id;
	private int userId;
	private int magazineId;
	private Date purchaseDate;
	
	public Bucket(int id, int userId, int magazineId, Date purchaseDate) {
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(int userId, int magazineId, Date purchaseDate) {
		this.userId = userId;
		this.magazineId = magazineId;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public int getMagazineId() {
		return magazineId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userId=" + userId + ", magazineId=" + magazineId + ", purchaseDate="
				+ purchaseDate + "]";
	}
	
	
	
}
