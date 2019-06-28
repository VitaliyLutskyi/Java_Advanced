package les17;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import les17.entity.University;
import les17.service.UniversityService;

@SpringBootApplication
public class Les17Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctxt = SpringApplication.run(Les17Application.class, args);
		
		UniversityService service = ctxt.getBean(UniversityService.class);
		
		University uv1 = new University("IFMU", 3, 2, 850, "Galytska str.");
		University uv2 = new University("IFNTUNG", 4, 5, 1180, "Carpatska str.");
		
		// Create
		service.save(uv1);
		service.save(uv2);
		
		// Read all
		System.out.println("--------------------------------------------------------");
		service.findAll().forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		
		// Read by name
		System.out.println(service.findByName("IFMU"));
		System.out.println("--------------------------------------------------------");
		
		// Read by id
		University university = service.findById(2);
		System.out.println(university);
		System.out.println("--------------------------------------------------------");
		
		// Update
		university.setAddress("Mlynarska str.");
		service.update(university);
		service.findAll().forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		
		// delete
		service.deleteById(1);
		service.findAll().forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
	}

}
