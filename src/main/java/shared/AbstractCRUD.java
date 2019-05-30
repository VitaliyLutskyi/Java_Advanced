package shared;

import java.util.List;

public interface AbstractCRUD <T>{
	
	public T create(T t);
	
	public T read(int id);
	
	public List<T> readAll();
	
	public void update(T t);
	
	public void delete(int id);
}
