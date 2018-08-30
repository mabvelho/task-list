package tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Controller
public class WebController {
	
	private final TaskRepository repository;
	
	public WebController(TaskRepository r) {
		this.repository = r;
	}

	@GetMapping("/")
	public String listAll(Model model, TaskForm taskForm) {
		model.addAttribute("taskList", this.repository.findAll());

		return "form";
	}

	@PostMapping("/")
	public String addTask(TaskForm taskForm, Model model) {
		if (hasErrors(taskForm)) {
			model.addAttribute("taskList", this.repository.findAll());
            return "form";
		}
		this.repository.save(taskForm);

		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable("id") Long id) {

		TaskForm t = new TaskForm(id);
		this.repository.delete(t);

		return "redirect:/";
	}
	
	private boolean hasErrors(TaskForm taskForm) {
		return !(2 < taskForm.getTask().length() && taskForm.getTask().length() < 30);
	}
}
