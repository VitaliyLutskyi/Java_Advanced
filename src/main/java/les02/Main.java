package les02;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		GoodDAO goodDAO = new GoodDAO();
		SupplierDAO supplierDAO = new SupplierDAO();
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		List<Good> listOfGoods = new ArrayList<Good>();
		List<Supplier> listOfSuppliers = new ArrayList<Supplier>();
		
		listOfEmployees.add(new Employee("Іван", "Бобик", "0503732560", "вул. Сагайдачного 8"));
		listOfEmployees.add(new Employee("Оксана", "Прокопенко", "0672598712", "вул. Пасічна 45"));
		listOfEmployees.add(new Employee("Галина", "Микулин", "0632223344", "вул. Хіміків 21/36"));
		listOfEmployees.add(new Employee("Анна", "Петрів", "0504332328", "вул. Мазепи 18/25"));
		
		listOfGoods.add(new Good("Кіндер шок Т8", 5.25, 36));
		listOfGoods.add(new Good("Чіпси Прінглз бекон 170г", 75.50, 8));
		listOfGoods.add(new Good("Вода Бювет 1.5 сл газ", 12.75, 60));
		listOfGoods.add(new Good("Порошок Аріел 400г", 23, 30));
		listOfGoods.add(new Good("Шок Міленіум пор чорн 100г", 24.5, 15));
		
		listOfSuppliers.add(new Supplier("ПТД", "вул. Ребета 12", "0675698777", "ptd@ukr.net"));
		listOfSuppliers.add(new Supplier("САВ Сервіс", "вул. Вовчинецька 223", "0502323656", "savservice@gmail.com"));
		listOfSuppliers.add(new Supplier("Рома", "с. Черніїв, вул. Бандери 23", "0507785622", "roma@gmail.com"));
				
										//CRUD operations with Employee
		// Create
		listOfEmployees.forEach(t -> {
			try {
				employeeDAO.insert(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		// Read all
		employeeDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		
		// Read by id
		System.out.println(employeeDAO.read(3));
		System.out.println("*****************************************************************************");
		
		// Update
		employeeDAO.update(new Employee(2, "Петро", "Івасів", "0662345212", "вул. Мазепи 29"));
		System.out.println(employeeDAO.read(2));
		System.out.println("*****************************************************************************");
		
		// Delete
		employeeDAO.delete(2);
		employeeDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		System.out.println("\n*****************************************************************************");
		
										//CRUD operations with Good
		// Create
		listOfGoods.forEach(t -> {
			try {
				goodDAO.insert(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		// Read all
		goodDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		
		// Read by id
		System.out.println(goodDAO.read(5));
		System.out.println("*****************************************************************************");
		
		// Update
		goodDAO.update(new Good(4, "Orbit", 10.5, 23));
		System.out.println(goodDAO.read(4));
		System.out.println("*****************************************************************************");
		
		// Delete
		goodDAO.delete(1);
		goodDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		System.out.println("\n*****************************************************************************");
		
										//CRUD operations with Supplier
		// Create
		listOfSuppliers.forEach(t -> {
			try {
				supplierDAO.insert(t);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		// Read all
		supplierDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		
		// Read by id
		System.out.println(supplierDAO.read(2));
		System.out.println("*****************************************************************************");
		
		// Update
		supplierDAO.update(new Supplier(1, "ТДК", "вул. Чорновола 129", "0342772925", "tdk@gmail.com"));
		System.out.println(supplierDAO.read(1));
		System.out.println("*****************************************************************************");
		
		// Delete
		supplierDAO.delete(3);
		supplierDAO.readAll().forEach(System.out::println);
		System.out.println("*****************************************************************************");
		
		
		
		
		
	}
}
