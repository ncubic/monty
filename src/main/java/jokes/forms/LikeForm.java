package jokes.forms;

import javax.validation.constraints.NotNull;

/**
 * Form used for like/dislike AJAX submissions.
 */
public class LikeForm {
	@NotNull
	private Integer id;

	/**
	 * Get joke id.
	 * @return joke id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set joke id.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
