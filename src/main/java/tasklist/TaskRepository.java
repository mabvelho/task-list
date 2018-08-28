package tasklist;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface TaskRepository extends Repository<TaskForm, Long> {

	public List<TaskForm> findAll();
	
	public void save(TaskForm task);
}
