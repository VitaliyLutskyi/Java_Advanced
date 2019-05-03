package les01;

import java.io.Serializable;

public class Seance implements Comparable<Seance>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Movie movie;
	private Time startTime;
	private Time endTime;
	
	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = startTime.add(movie.getDuration());
	}
	
	public Movie getMovie() {
		return movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}
	
	
	@Override
	public String toString() {
		return "Գ��� " + movie.getTitle() + ", ���������� � " + startTime + ", ���������� � " + endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seance other = (Seance) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public int compareTo(Seance s) {
		return this.startTime.compareTo(s.startTime);
	}
	
	
}
