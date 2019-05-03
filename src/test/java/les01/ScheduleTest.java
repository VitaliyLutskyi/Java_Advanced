package les01;

import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ScheduleTest {
	private static Movie movie;
	private static Seance seance;
	private static Schedule schedule;
	private static TreeSet<Seance> seanceSet;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, Description description) {
			System.out.println("FAILED--->" + this.getClass().getName() +"."+ description.getMethodName());
		};

		protected void succeeded(Description description) {
			System.out.println("SUCCEEDED--->" + this.getClass().getName() +"."+ description.getMethodName());
		};
	};

	@BeforeClass
	public static void beforeClass() {
		movie = new Movie("Scary Movie", new Time(45, 1));
		seance = new Seance(movie, new Time(0, 14));
		seanceSet = new TreeSet<Seance>();
		seanceSet.add(seance);
	}

	@Before
	public void before() {
		schedule = new Schedule();
	}

	@Test
	public void addSeanceTest() {
		schedule.addSeance(seance);
		Assert.assertEquals(seanceSet, schedule.getSeanceSet());
	}

	@Test(expected = NotCorrectTimeException.class)
	public void addSeanceTestWithPreviousMovieConflict() {
		Seance seance2 = new Seance(movie, new Time(50, 15));
		schedule.addSeance(seance);
		schedule.addSeance(seance2);
	}

	@Test(expected = NotCorrectTimeException.class)
	public void addSeanceTestWithNextMovieConflict() {
		Seance seance2 = new Seance(movie, new Time(10, 12));
		schedule.addSeance(seance);
		schedule.addSeance(seance2);
	}

	@Test
	public void removeSeanceTest() {
		Seance seance2 = new Seance(movie, new Time(10, 17));
		schedule.addSeance(seance);
		schedule.addSeance(seance2);
		schedule.removeSeance(seance2);
		Assert.assertEquals(seanceSet, schedule.getSeanceSet());

	}
}
