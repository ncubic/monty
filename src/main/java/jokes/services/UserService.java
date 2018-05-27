package jokes.services;

import jokes.entities.User;

/**
 * Service layer interface for user entities.
 */
public interface UserService {
	void save(User user);
}