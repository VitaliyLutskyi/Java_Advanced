package les01;

import java.io.Serializable;

public class Time implements Comparable<Time>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte min;
	private byte hour;
	private byte day;
	
	public Time(int min, int hour) throws NotCorrectTimeException{
		if(min<0 || min >59 || hour<0 || hour>23)
			throw new NotCorrectTimeException("���������� ������� ���!");
		this.min = (byte) min;
		this.hour = (byte) hour;	
	}
	
	// For case when seance end time is after midnight
	public Time(int min, int hour, int day) throws NotCorrectTimeException{
		if(min<0 || min >59 || hour<0 || hour>23)
			throw new NotCorrectTimeException("���������� ������� ���!");
		this.min = (byte) min;
		this.hour = (byte) hour;
		this.day = (byte) day;
	}

	public Time add(Time time) throws NotCorrectTimeException{
		
		byte resultMin, resultHour, resultDay = 0;
		resultMin = (byte) (this.min + time.min);
		resultHour = (byte) (this.hour + time.hour);
		resultDay = (byte) (this.day + time.day);
		if(resultMin > 59) {
			resultMin -=60;
			resultHour++;
		}
		if(resultHour > 23) {
			resultHour -=24;
			resultDay++;
		}
		return new Time(resultMin, resultHour, resultDay);
	}

	@Override
	public int compareTo(Time t) {
		if ((day*24*60+hour*60+min) > (t.day*24*60+t.hour*60+t.min)) 
			return 1;
		else if ((day*24*60+hour*60+min) < (t.day*24*60+t.hour*60+t.min)) 
			return -1;
		else 
			return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + hour;
		result = prime * result + min;
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
		Time other = (Time) obj;
		if (day != other.day)
			return false;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String m = (min<10) ? "0" : "";
			return hour+":"+m+ min;
	}
	
	
	
}
