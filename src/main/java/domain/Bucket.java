package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bucket")
public class Bucket {
	
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "magazine_id", referencedColumnName = "id")
	private Magazine magazine;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	public Bucket() {}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", magazine=" + magazine + ", purchaseDate=" + purchaseDate
				+ "]";
	}
	
	
}
