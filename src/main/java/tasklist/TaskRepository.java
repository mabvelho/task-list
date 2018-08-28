package tasklist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskForm, Long> {

	public List<TaskForm> displayAllTasks();
	
	public void addToList(TaskForm task);
}
