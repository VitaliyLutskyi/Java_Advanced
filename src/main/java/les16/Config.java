package les16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(name = "studentDao")
	public StudentDAO getStudentDaoImpl() {
		StudentDaoImpl studentDao = new StudentDaoImpl();
		Student st1 = new Student(1, 18, "Oleg");
		Student st2 = new Student(2, 20, "Petro");
		Student st3 = new Student(3, 19, "Vasyl");
		Student st4 = new Student(4, 20, "Igor");
		List<Student> students =  new ArrayList<Student>(Arrays.asList(st1, st2, st3, st4)) ;
		studentDao.setStudents(students);
		
		return studentDao;
	}
	
	@Bean(name = "consoleLogger")
	public ConsoleLogger getConsoleLogger() {
		return new ConsoleLogger();
	}
}
