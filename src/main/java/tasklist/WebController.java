package tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

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
	public String addTask(@Valid @ModelAttribute(name="taskForm") TaskForm taskForm, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/";
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
}
