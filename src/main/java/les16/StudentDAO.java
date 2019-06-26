package les16;

import java.util.List;

public interface StudentDAO {
	
	public void create(Student student);
	public Student read(int id);
	public List<Student> readAll();
	public void update(Student student);
	public void delete(int id);
}
