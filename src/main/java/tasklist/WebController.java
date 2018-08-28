package tasklist;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
	
    @GetMapping("/")
    public String listAll(Model model, TaskRepository repository) {
    	model.addAttribute("taskList", repository.displayAllTasks());
    	
        return "taskList";
    }

    @PostMapping("/")
    public String addTask(@Valid TaskForm taskForm, BindingResult bindingResult, TaskRepository repository) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        repository.addToList(taskForm);
        
        return "redirect:/";
    }
}
