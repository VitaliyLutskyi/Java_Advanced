package les01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CinemaSchedulesEditing {
	
	public static Cinema work(Cinema cinema, Scanner s) throws FileNotFoundException, IOException {
		while (true) {
			System.out.println("\n������ 1 ��� ������ �����");
			System.out.println("������ 2 ��� ������ �����");
			System.out.println("������ 3 ��� ������ ����� ����� � ���� ���� ��������");
			System.out.println("������ 4 ��� �������� �����");
			System.out.println("������ 5 ��� �������� ����� ����� � ���� ���� ��������");
			System.out.println("������ 6 ��� ���������� ������� ���� �� ������ ����");
			System.out.println("������ 7 ��� ���������� ������ ��������� ������");
			System.out.println("������ 8 ��� ���������� �� ������� ������ ������ �� �������");
			System.out.println("������ 9 ��� ����������� �� ������������ ����");
			System.out.println("������ 0 ��� �����");

			int n;
			Time duration, startTime;
			String hallName, title;
			Days day = null;
			Movie movie;
			
			while (true) {
				try {
					n = Integer.parseInt(s.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("�� ������ ������ ���� ����� �� 0 �� 9");
					continue;
				}
			}
			switch (n) {
			case 1:
				System.out.println("������ ����� ������");
				title = s.nextLine();
				duration = readTime("������ ��������� ������ � ������ hh:mm", s);
				cinema.addMovie(new Movie(title, duration));		
				break;
				
			case 2:
				movie = readMovie(cinema, s);
				if (movie != null) {
					hallName = readHall(cinema, s);
					if (hallName != null) {
						day = readDay(s);
						if(day != null) {
							startTime = readTime("������ ��� ������� ������", s);
							try {
								cinema.addSeance(hallName, day, new Seance(movie, startTime));
							} catch (NotCorrectTimeException e) {
								System.out.println(e.getMessage());
							}
								
						}
					}
				}
				break;
				
			case 3:
				System.out.println("������ ����� ������");
				title = s.nextLine();
				duration = readTime("������ ��������� ������ � ������ hh:mm", s);
				hallName = readHall(cinema, s);
				if (hallName != null) {
					day = readDay(s);
					if (day != null) {
						String timesStr;
						while (true) {
							System.out.println("������ ���� ������� ������ � ������ hh:mm ����� �����");
							timesStr = s.nextLine();
							// Remove double spaces
							while (timesStr.indexOf("  ") != -1)
								timesStr = timesStr.replace("  ", " ");
							if (!(timesStr.equals("") || timesStr.equals(" ") ))
								break;
						}
						String[] timesArr = timesStr.split(" ");
						Time[] times = new Time[timesArr.length];
						for (int i = 0; i < timesArr.length; i++) {
							try {
								times[i] = toTime(timesArr[i]);
							} catch (NotCorrectTimeException e) {
								System.out.println("���������� ������� ���. ���������: 0..23��� 0..59��");
								break;
							} catch (Exception e) {
								System.out.println("���������� ������� ���.");
								break;
							}
						}
						cinema.addMovie(new Movie(title, duration), hallName, day, times);
					}
				}
				break;
				
			case 4:
				movie = readMovie(cinema, s);
				if (movie != null) {
					hallName = readHall(cinema, s);
					if (hallName != null) {
						day = readDay(s);
						if(day != null) {
							startTime = readTime("������ ��� ������� ������", s);
							cinema.removeSeance(new Seance(movie, startTime), hallName, day);	
						}
					}
				}
				break;
				
			case 5:
				movie = readMovie(cinema, s);
				if (movie != null) {
					cinema.removeMovie(movie);
				}
				break;
				
			case 6:
				hallName = readHall(cinema, s);
				if (hallName != null) {
					day = readDay(s);
					if(day != null) 
						System.out.println("������� ���� "+hallName+" �� "+day+". "+cinema.getSchedule(hallName, day));
				}
				break;
				
			case 7:
				System.out.println("������� ��� ��������� ������:");
				cinema.refreshMovies();
				cinema.getMovies().forEach(System.out::println);
				break;
				
			case 8:
				movie = readMovie(cinema, s);
				if (movie != null) {
					for(Hall h:cinema.getHalls()) {
						for (Days d:Days.values()) {
							h.getSchedules().get(d).getSeanceSet().stream().filter(sc->sc.getMovie().
									equals(movie)).forEach(sc->System.out.println(h.getName()+" ��� "+d+" "+sc));
						}
					}
				}
				break;
			case 9: 
				return cinema;
			case 0:
				s.close();
				Main.save(cinema);
				System.exit(0);
				break;
			default:
				System.out.println("����� ������� ���� �� 0 �� 9");
			}
		}
		
	}
	
	private static Movie readMovie(Cinema cinema, Scanner s) {
		Movie movie;
		System.out.println("������ ����� ������");
		String title= s.nextLine();
		movie = cinema.getMovieByTitle(title);
		if(movie == null) 
			System.out.println("���� ������ ������");
		return movie;
	}
	
	private static String readHall(Cinema cinema, Scanner s) {
		String hallName;
		System.out.println("������ ����� ����");
		hallName = s.nextLine();
		if(!(cinema.getHallNames().contains(hallName))) {
			System.out.println("���� ������ ����");
			hallName = null;
		}
		return hallName;
	}
	
	private static Days readDay(Scanner s) {
		Days day = null;
		System.out.println("������ ���� �����");
		String dayName = s.nextLine();
		for(Days d:Days.values()) 
			if (d.name().equalsIgnoreCase(dayName))
				day=d;
		if(day == null) 
			System.out.println("���� ������ ���");
		return day;
	}
	
	public static Time readTime(String message, Scanner s) {
		Time time;
		while (true) {
			System.out.println(message);
			try {
				time = toTime(s.nextLine());
				break;
			} catch (NotCorrectTimeException e) {
				System.out.println("���������� ������� ���. ���������: 0..23��� 0..59��");
			}
			catch (Exception e) {
				System.out.println("���������� ������� ���.");
			}
		}
		return time;
	}
	
	private static Time toTime(String s) {
		String[] split = s.split(":");
		int hours = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		return new Time(min,hours);
	}

}


































