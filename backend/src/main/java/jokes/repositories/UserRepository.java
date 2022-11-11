package jokes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jokes.entities.User;

@Repository
/**
 * Repository layer for user entities.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * Retrieve user by username.
	 *
	 * @param username
	 * @return user
	 */
	User findByUsername(String username);
}