package jokes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
/**
 * Model user entity used for authentication.
 */
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;

	/**
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 * Constructor with username and password.
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Get user identifier.
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set user identifier.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get username.
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Set username.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get user password.
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set user password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}