package tasklist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
@Table(name = "TASKS")
public class TaskForm {

    @NotNull
    @Size(min=2, max=100)
    private String task;
    
    @Id
	@SequenceGenerator(name="SEQ_TASKS", sequenceName="SEQ_TASKS", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TASKS")   
    private Long id;
    
    protected TaskForm() {}
    
    public TaskForm(String task) {
    	this.task = task;
    }
	
	public TaskForm(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
    
    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String toString() {
        return "Task: " + this.task;
    }
}