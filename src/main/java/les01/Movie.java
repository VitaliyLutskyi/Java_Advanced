package les01;

import java.io.Serializable;

public class Movie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private Time duration;
	
	public Movie(String title, Time duration) {
		this.title = title;
		this.duration = duration;
	}
	
	
	public Movie(String title) {
		this.title = title;
	}


	public String getTitle() {
		return title;
	}
	
	public Time getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return "Գ��� " + title + ", ��������� " + duration;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.toLowerCase().hashCode());
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
		Movie other = (Movie) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equalsIgnoreCase(other.title))
			return false;
		return true;
	}

	
	
	
}
