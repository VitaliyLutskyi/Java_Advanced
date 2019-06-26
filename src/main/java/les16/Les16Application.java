package les16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Les16Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Les16Application.class, args);
		
		StudentDaoImpl studentDao = (StudentDaoImpl) ctxt.getBean("studentDao");
		ConsoleLogger cl = (ConsoleLogger) ctxt.getBean("consoleLogger");
		
		studentDao.create(new Student(8, 21, "Olga"));
		
		studentDao.readAll().stream().map(st->st.toString()).forEach(cl::consoleLog);		

		studentDao.update(new Student(3, 17, "Mykola"));
		
		cl.consoleLog("--------------------------------------------------------------------");
		cl.consoleLog(studentDao.read(3).toString());
		
		studentDao.delete(2);
		
		cl.consoleLog("--------------------------------------------------------------------");
		studentDao.readAll().stream().map(st->st.toString()).forEach(cl::consoleLog);
	}

}
