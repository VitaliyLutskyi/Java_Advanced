package les01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeTest {
	
	static Time time;
	
	@BeforeClass
	public static void beforeClass() {
		time = new Time(55, 22);
	}
	@AfterClass
	public static void afterClass() {
		time = null;
	}

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {
			System.out.println("SUCCEEDED---> " + this.getClass().getName() + "." + description.getMethodName());
		}

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("FAILED---> " + this.getClass().getName() + "." + description.getMethodName());
		}
	};

	@Test
	public void addTest() {
		Time time2 = new Time(1, 1);
		Time time3 = new Time(10, 10);
		Time realTime2 = time.add(time2);
		Time realTime3 = time.add(time3);
		Time expectedTime2 = new Time(56, 23);
		Time expectedTime3 = new Time(5, 9, 1);
		Assert.assertEquals(expectedTime2, realTime2);
		Assert.assertEquals(expectedTime3, realTime3);
		
	}
	@Test(expected = NotCorrectTimeException.class)
	public void addTestWithException() {
		Time time4 = new Time(60, 2);
		time4.toString();
	}
}
