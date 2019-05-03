package les01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);
	static File folder = new File("cinemas");

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Cinema cinema;
		File file;

		if (!folder.exists())
			folder.mkdir();

		int n;
		while (true) {
			System.out.println("\n������ 1 ��� ��������� � �������� ����������");
			System.out.println("������ 2 ��� ������ ����� ��������");
			System.out.println("������ 3 ��� ���������� ������ �������� ���������");
			System.out.println("������ 0 ��� �����");

			while (true) {
				try {
					n = Integer.parseInt(s.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("�� ������ ������ ���� ����� �� 0 �� 3");
					continue;
				}
			}
			switch (n) {
			case 1:
				System.out.println("������ ����� ���������");
				String cinemaName = s.nextLine();
				file = Arrays.asList(folder.listFiles()).stream()
						.filter(f -> cinemaName.concat(".txt").equalsIgnoreCase(f.getName())).findFirst().orElse(null);
				if (file == null)
					System.out.println("���� ������ ���������");
				else {
					cinema = CinemaSchedulesEditing.work(open(file), s);
					save(cinema);
				}

				break;
			case 2:
				cinema = createCinema();
				if (cinema==null)
					break;
				cinema = CinemaSchedulesEditing.work(cinema, s);
				file = new File(folder, cinema.getName() + ".txt");
				save(cinema);
				break;
			case 3:
				System.out.println("������� ���������:");
				Arrays.asList(folder.list()).stream().map(str -> str.substring(0, str.length() - 4))
						.forEach(System.out::println);
				break;
			case 0:
				s.close();
				System.exit(0);
				break;
			default:
				System.out.println("����� ������� ���� �� 0 �� 3");
			}
		}

	}

	private static Cinema createCinema() {
		Time open, close;
		String hallNames;

		System.out.println("������ ����� ���������");
		String cinemaName = s.nextLine();
		File file = Arrays.asList(folder.listFiles()).stream()
				.filter(f -> cinemaName.concat(".txt").equalsIgnoreCase(f.getName())).findFirst().orElse(null);
		if (file != null) {
			System.out.println("����� �������� ��� �.");
			return null;
		}
		open = CinemaSchedulesEditing.readTime("������ ��� �������� ���������", s);
		close = CinemaSchedulesEditing.readTime("������ ��� �������� ���������", s);

		// If closes after midnight day++
		if (close.compareTo(open) < 1)
			close = close.add(new Time(0, 0, 1));

		while (true) {
			System.out.println("������ ����� ���� ����� �����");
			hallNames = s.nextLine();

			// Remove double spaces
			while (hallNames.indexOf("  ") != -1)
				hallNames = hallNames.replace("  ", " ");
			if (!(hallNames.equals("") || hallNames.equals(" ")))
				break;
		}
		String[] halls = hallNames.split(" ");
		Cinema cinema = new Cinema(cinemaName, open, close, halls);

		System.out.println("������: " + cinema);
		System.out.println();
		return cinema;
	}

	public static void save(Cinema c) throws FileNotFoundException, IOException {
		File file = new File(folder, c.getName() + ".txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(c);
		oos.close();
	}

	private static Cinema open(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Cinema obj = (Cinema) ois.readObject();
		ois.close();
		return obj;
	}

}
