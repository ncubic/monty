
package jokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * Handles Login operation.
 */
public class LoginController {

	@GetMapping("/login")
	/**
	 * Creates a login form.
	 */
	public String login() {
		return "login";
	}
}