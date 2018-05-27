package jokes.entities;

import javax.persistence.*;
import java.util.List;

@Entity
/**
 * Models joke category.
 */
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "category")
	private List<Joke> jokes;
	@Column(nullable = false)
	private String name;

	/**
	 * Get category identifier.
	 *
	 * @return category id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set category identifier.
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get category name.
	 *
	 * @return category name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set category name.
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}