package les01;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Time open;
	Time close;
	HashSet<Hall> halls;
	HashSet<Movie> movies;

	public String getName() {
		return name;
	}

	public Time getOpen() {
		return open;
	}

	public Time getClose() {
		return close;
	}

	public HashSet<Hall> getHalls() {
		return halls;
	}

	public HashSet<Movie> getMovies() {
		return movies;
	}
	
	public Movie getMovieByTitle(String title) {
		Movie result = null;
		for (Movie m:movies)
			if(m.getTitle().equalsIgnoreCase(title))
				result = m;
		return result;
	}
	
	public HashSet<String> getHallNames() {
		HashSet<String> result = new HashSet<String>();
		halls.forEach(h->result.add(h.getName()));
		return result;
	}
	public Cinema(String name, Time open, Time close, String... hallNames) {
		this.name = name;
		this.open = open;
		this.close = close;
		this.movies = new HashSet<Movie>();
		this.halls = new HashSet<Hall>();
		Arrays.asList(hallNames).stream().forEach(h->halls.add(new Hall(h)));
	}
	
	
	@Override
	public String toString() {
		String hallsNames = "";
		for (Hall h : halls)
			hallsNames += h.getName() + " ";
		return "ʳ������� " + name + " ������ � " + open + " �� " + close + "\n����������� ������ ����� � "
				+ halls.size() + " �����: " + hallsNames;
	}
	
	void addSeance(String hallName, Days day, Seance s) {
		if (s.getStartTime().compareTo(open) == -1)
			s = new Seance(s.getMovie(), s.getStartTime().add(new Time(0, 0, 1)));
		if (s.getEndTime().compareTo(close) == 1)
			throw new NotCorrectTimeException("Seance's time doesn't match with cinema's work schedule!");
		TreeMap<Days, Schedule> schedules = halls.stream().filter(h -> h.getName().equalsIgnoreCase(hallName))
				.findFirst().get().getSchedules();
		schedules.get(day).addSeance(s);
	}
	
	void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	void addMovie(Movie movie, String hallName, Days day, Time... times) {
		movies.add(movie);
		Arrays.asList(times).stream().forEach(t -> {
			try {
				addSeance(hallName, day, new Seance(movie, t));
			} catch (NotCorrectTimeException e) {
				System.out.print("Seance at "+t+" hasn't been added. ");
				System.out.println(e.getMessage());
			}
		});

	}

	void removeSeance(Seance seance, String hallName, Days day) {

		Hall hall = halls.stream().filter(h -> h.getName().equalsIgnoreCase(hallName)).findFirst().get();
		hall.getSchedules().get(day).removeSeance(seance);
	}

	void removeMovie(Movie movie) {
		movies.remove(movie);
		for(Hall h:halls)
			for(Days d:Days.values()) {
				Iterator<Seance> iterator = h.getSchedules().get(d).getSeanceSet().iterator();
				while(iterator.hasNext())	{
						Seance next = iterator.next();
						if (next.getMovie().equals(movie))
							iterator.remove();
					}
			}
	}
	
	Schedule getSchedule(String hallName, Days day) {
		return halls.stream().filter(h->h.getName().equalsIgnoreCase(hallName)).findFirst().get().getSchedules().get(day);
	}
	
	void refreshMovies() {
		movies.clear();
		for(Hall h:halls) 
			for (Days d:Days.values()) 
				for(Seance sc:h.getSchedules().get(d).getSeanceSet())
					movies.add(sc.getMovie());
	}

}
