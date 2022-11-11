package jokes.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import jokes.entities.Category;

/**
 * Form used for joke submission.
 */
public class JokeForm {
	@NotEmpty
	private String content;

	@NotNull
	private Category category;

	/**
	 * Get joke content.
	 * @return joke content
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Set joke content.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Get joke category.
	 * @return category
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Set joke category.
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}