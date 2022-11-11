package jokes.services;

import java.util.List;
import java.util.Optional;

import jokes.entities.Joke;

/**
 * Service layer interface for joke entities.
 */
public interface JokeService {
	/**
	 * List all jokes.
	 *
	 * @return list of jokes.
	 */
	List<Joke> listAll();

	/**
	 * Insert joke into repository.
	 *
	 * @param joke
	 */
	void insert(Joke joke);

	/**
	 * Update joke in repository.
	 *
	 * @param joke
	 */
	void update(Joke joke);

	/**
	 * Find joke in repository.
	 *
	 * @param id
	 * @return Optional object with joke
	 */
	Optional<Joke> find(Integer id);
}