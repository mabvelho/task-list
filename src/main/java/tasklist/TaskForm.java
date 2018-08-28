package tasklist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TaskForm {

    @NotNull
    @Size(min=2, max=30)
    private String task;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull    
    private Long id;
    
    protected TaskForm() {}
    
    public String getName() {
        return this.task;
    }

    public void setName(String task) {
        this.task = task;
    }

    public String toString() {
        return "Task: " + this.task;
    }
}