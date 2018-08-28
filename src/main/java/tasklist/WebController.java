package tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	
	private final TaskRepository repository;
	
	public WebController(TaskRepository r) {
		this.repository = r;
	}

	@GetMapping("/")
	public String listAll(Model model) {
		model.addAttribute("taskList", this.repository.findAll());

		return "form";
	}

	@PostMapping("/")
	public String addTask(TaskForm taskForm) {

		this.repository.save(taskForm);

		return "redirect:/";
	}
}
