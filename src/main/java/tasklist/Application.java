package tasklist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
	
	/*@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new TaskForm("Jack"));
			repository.save(new TaskForm("Chloe"));
			repository.save(new TaskForm("Kim"));
			repository.save(new TaskForm("David"));
			repository.save(new TaskForm("Michelle"))
		};
	}*/

}