package les01;

import java.util.HashSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CinemaTest {
	
	private static Movie movie;
	private static Seance seance;
	private Schedule scheduleExpected;
	private Cinema cinema;
	private Schedule scheduleActual;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {
			System.out.println("SUCCEEDED--->" + this.getClass().getName() +"."+ description.getMethodName());
		}

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("FAILED--->" + this.getClass().getName() +"."+ description.getMethodName());
		}
	};
	
	@BeforeClass
	public static  void beforeClass() {
		movie = new Movie("Scary Movie", new Time(45, 1));
		seance = new Seance(movie, new Time(0, 14));
	}

	@Before
	public void before() {
		scheduleExpected = new Schedule();
		scheduleActual = new Schedule();
		cinema = new Cinema("Kosmos", new Time(0, 9), new Time(0, 23), "Red", "Blue");
	}
	
	@Test
	public void addSeanceTest() {
		scheduleExpected.addSeance(seance);
		cinema.addSeance("Red", Days.SUNDAY, seance);
		scheduleActual = cinema.getHalls().stream().filter(h->h.getName().equals("Red"))
				.findFirst().get().getSchedules().get(Days.SUNDAY);
		Assert.assertEquals(scheduleExpected, scheduleActual);
	}
	
	@Test(expected = NotCorrectTimeException.class)
	public void addSeanceTestWithTooEarlyException() {
		cinema.addSeance("Red", Days.SUNDAY, new Seance(movie, new Time(50, 8)));
	}
	
	@Test(expected = NotCorrectTimeException.class)
	public void addSeanceTestWithTooLateException() {		
		cinema.addSeance("Red", Days.SUNDAY, new Seance(movie, new Time(30, 21)));
	}
	
	@Test
	public void getScheduleTest() {
		cinema.addSeance("Blue", Days.FRIDAY, seance);
		scheduleExpected.addSeance(seance);
		scheduleActual = cinema.getSchedule("Blue", Days.FRIDAY);
		Assert.assertEquals(scheduleExpected, scheduleActual);
	}
	
	@Test
	public void addMovieTest() {
		cinema.addMovie(movie);
		HashSet<Movie> moviesExpected = new HashSet<Movie>();
		moviesExpected.add(movie);
		Assert.assertEquals(moviesExpected, cinema.getMovies());
	}
	
	@Test
	public void addMovieTestWithSeances() {
		Time time1 = new Time(0, 9);
		Time time2 = new Time(10, 11);
		Time time3 = new Time(0, 13);
		Time time4 = new Time(0, 20);
		Time time5 = new Time (0, 8);
		Time time6 = new Time (0, 22);
		cinema.addMovie(movie, "Red", Days.TUESDAY, time1, time2, time3, time4, time5, time6);
		scheduleActual = cinema.getSchedule("Red", Days.TUESDAY);
		scheduleExpected.addSeance(new Seance(movie, time1));
		scheduleExpected.addSeance(new Seance(movie, time2));
		scheduleExpected.addSeance(new Seance(movie, time4));
		Assert.assertEquals(scheduleExpected, scheduleActual);
	}
	
	@Test
	public void getMovieByTitleTest() {
		cinema.addMovie(movie);
		Movie movieActual = cinema.getMovieByTitle("scary movie");
		Assert.assertEquals(movie, movieActual);
	}
	
	@Test
	public void getHallNamesTest() {
		HashSet<String> hallNamesExpected = new HashSet<String>();
		hallNamesExpected.add("Red");
		hallNamesExpected.add("Blue");
		Assert.assertEquals(hallNamesExpected, cinema.getHallNames());
	}
	
	@Test
	public void removeSeanceTest() {
		cinema.addSeance("Red", Days.FRIDAY, seance);
		cinema.addSeance("Red", Days.FRIDAY, new Seance(movie, new Time(0, 10)));
		cinema.removeSeance(seance, "Red", Days.FRIDAY);
		scheduleActual = cinema.getSchedule("Red", Days.FRIDAY);
		scheduleExpected.addSeance(new Seance(movie, new Time(0, 10)));
		Assert.assertEquals(scheduleExpected, scheduleActual);
	}
	
	@Test
	public void removeMovieTest() {
		Movie movie2 = new Movie("Gladiator", new Time(30, 1));
		Time time1 = new Time(0, 9);
		Time time2 = new Time(10, 11);
		Time time4 = new Time(0, 20);
		cinema.addMovie(movie, "Red", Days.TUESDAY, time1, time2, time4);
		cinema.addMovie(movie, "Blue", Days.FRIDAY, time1, time2, time4);
		cinema.addMovie(movie2, "Red", Days.FRIDAY, time2, time4);
		cinema.addSeance("Red", Days.FRIDAY, new Seance(movie, new Time(0, 14)));
		cinema.removeMovie(movie);
		Assert.assertEquals(scheduleExpected, cinema.getSchedule("Red", Days.TUESDAY));
		Assert.assertEquals(scheduleExpected, cinema.getSchedule("Blue", Days.FRIDAY));
		scheduleExpected.addSeance(new Seance(movie2, time2));
		scheduleExpected.addSeance(new Seance(movie2, time4));
		Assert.assertEquals(scheduleExpected, cinema.getSchedule("Red", Days.FRIDAY));
	}
	
	@Test
	public void refreshMoviesTest() {
		HashSet<Movie> moviesExpected = new HashSet<Movie>();
		Movie movie2 = new Movie("Gladiator", new Time(30, 1));
		Time time1 = new Time(0, 9);
		Time time2 = new Time(10, 11);
		Time time4 = new Time(0, 20);
		cinema.addMovie(movie, "Red", Days.TUESDAY, time1, time2, time4);
		cinema.addMovie(movie2, "Red", Days.FRIDAY, time2, time4);
		cinema.removeMovie(movie2);
		cinema.refreshMovies();
		moviesExpected.add(movie);
		Assert.assertEquals(moviesExpected, cinema.getMovies());
		cinema.addMovie(movie2, "Red", Days.FRIDAY, time2, time4);
		cinema.removeSeance(new Seance(movie2, time2), "Red", Days.FRIDAY);
		cinema.removeSeance(new Seance(movie2, time4), "Red", Days.FRIDAY);
		cinema.refreshMovies();
		Assert.assertEquals(moviesExpected, cinema.getMovies());
	}
}













