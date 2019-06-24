package les14;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( )
public class Cart {
	
	private int id;
	private int total;
	private String name;
	private Set<Item> items = new HashSet<Item>();
	
	public Cart() {}

	public Cart(int total, String name) {
		super();
		this.total = total;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getTotal() {
		return total;
	}

	public String getName() {
		return name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + ", name=" + name + ", items=" + items + "]";
	}
	
	
}
