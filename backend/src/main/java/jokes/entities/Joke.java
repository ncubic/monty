package jokes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
/**
 * Model entity joke.
 */
public class Joke {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Category category;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private Integer likes = 0;
	@Column(nullable = false)
	private Integer dislikes = 0;

	/**
	 * Default constructor.
	 */
	public Joke() {
	}

	/**
	 * Get joke identifier.
	 * @return joke id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Get joke category.
	 * @return category
	 */
	public Category getCategory() {
		return this.category;
	}

	/**
	 * Set joke category
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

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
	 * Get count of likes for joke.
	 * @return likes count
	 */
	public Integer getLikes() {
		return this.likes;
	}

	/**
	 * Increment joke likes count.
	 */
	public void incrementLikes() {
		this.likes++;
	}

	/**
	 * Get joke dislikes count.
	 * @return dislikes count
	 */
	public Integer getDislikes() {
		return this.dislikes;
	}

	/**
	 * Increment joke dislikes count.
	 */
	public void incrementDislikes() {
		this.dislikes++;
	}
}