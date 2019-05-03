package les01;

import java.io.Serializable;
import java.util.Arrays;
import java.util.TreeMap;

public class Hall implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	TreeMap<Days, Schedule> schedules;
	
	public Hall(String name) {
		this.name = name;
		this.schedules = new TreeMap<Days, Schedule>();
		Days[] days = Days.values();
		Arrays.asList(days).stream().forEach(d->schedules.put(d, new Schedule()));
	}

	public String getName() {
		return name;
	}
	
	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
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
		Hall other = (Hall) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}
	
}
