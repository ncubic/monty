package jokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import jokes.formatters.CategoryFormatter;
import jokes.entities.User;
import jokes.services.UserService;

@SpringBootApplication
/**
 * Main application class.
 */
public class Application {

	/**
	 * Run Spring boot application.
	 * @param args
	 */
	public static void main(String[] args) {
	  SpringApplication.run(Application.class, args);
	}

	@Configuration
	/**
	 * Spring MVC configuration class.
	 */
	static class MyConfig extends WebMvcConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Override
		/**
		 * Custom formatters used by Monty for form submission.
		 */
        public void addFormatters(FormatterRegistry registry) {
          registry.addFormatter(new CategoryFormatter());
        }

        @Bean
		/**
		 * Create BCryptPasswordEncoder used for hashing user passwords.
		 */
        public BCryptPasswordEncoder passwordEncoder() {
        	return new BCryptPasswordEncoder();
        }

        @EventListener
		/**
		 * Seed initial users with encrypted password on application start.
		 */
        public void seed(ContextRefreshedEvent event) {
            Map<String, String> users = new HashMap<>();
            users.put("pperic", "pero");
            users.put("iivic", "ivan");
            users.forEach((u,p) -> this.userService.save(new User(u,p)));
        }

    }

}