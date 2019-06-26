package les16;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO{
	
	private List<Student> students = new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public void create(Student student) {
		students.add(student);
	}

	@Override
	public Student read(int id) {
		return students.stream().filter(st->st.getId() == id).findFirst().get();
	}

	@Override
	public List<Student> readAll() {
		return students;
	}

	@Override
	public void update(Student student) {
		Student oldStudent = students.stream().filter(st->st.getId() == student.getId()).findFirst().get();
		students.set(students.indexOf(oldStudent), student);
		
	}

	@Override
	public void delete(int id) {
		students.remove(students.stream().filter(st->st.getId() == id).findFirst().get());
	}

}
