package jokes.controllers;

import jokes.AjaxResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import jokes.services.JokeService;
import jokes.services.CategoryService;
import jokes.forms.JokeForm;
import jokes.forms.LikeForm;
import jokes.entities.Joke;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;


@Controller
/**
 * Handle CRUD operations for Joke entity and like and dislike submissions.
 */
public class JokeController {

	@Autowired
	private JokeService jokeService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	/**
	 * Jokes index lists all jokes.
	 */
	public String index(Model model) {
		model.addAttribute("jokes", this.jokeService.listAll());
		return "jokes/index";
	}

	@GetMapping("/new")
	/**
	 * Show create new Joke form.
	 */
	public String createForm(Model model) {
		model.addAttribute("jokeForm", new JokeForm());
		model.addAttribute("categories", this.categoryService.listAll());
		return "jokes/new";
	}

	@PostMapping("/new")
	/**
	 * Handle new joke submission.
	 */
	public String createJoke(@Valid JokeForm jokeForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", this.categoryService.listAll());
			return "jokes/new";
		}

		Joke joke = new Joke();
		joke.setContent(jokeForm.getContent());
		joke.setCategory(jokeForm.getCategory());
		this.jokeService.insert(joke);

		return "redirect:/";
	}

	@PostMapping("/like")
	@ResponseBody
	/**
	 * Handle like joke submission.
	 */
	public ResponseEntity<?> likeJoke(@Valid @RequestBody LikeForm likeForm, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (errors.hasErrors()) {
			result.setMsg("Invalid request");
			return ResponseEntity.badRequest().body(result);
		}
		Optional<Joke> optJoke = this.jokeService.find(likeForm.getId());
		if (!optJoke.isPresent()) {
			result.setMsg("Invalid request");
			return ResponseEntity.badRequest().body(result);
		}
		Joke joke = optJoke.get();
		joke.incrementLikes();
		this.jokeService.update(joke);
		result.setMsg("Success");
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/dislike")
	@ResponseBody
	/**
	 * Handle dislike joke submission.
	 */
	public ResponseEntity<?> dislikeJoke(@Valid @RequestBody LikeForm likeForm, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (errors.hasErrors()) {
			result.setMsg("Invalid request");
			return ResponseEntity.badRequest().body(result);
		}
		Optional<Joke> optJoke = this.jokeService.find(likeForm.getId());
		if (!optJoke.isPresent()) {
			result.setMsg("Invalid request");
			return ResponseEntity.badRequest().body(result);
		}
		Joke joke = optJoke.get();
		joke.incrementDislikes();
		this.jokeService.update(joke);
		result.setMsg("Success");
		return ResponseEntity.ok().body(result);
	}

}