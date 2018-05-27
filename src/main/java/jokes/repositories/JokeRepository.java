package jokes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

import jokes.entities.Joke;

@Repository
/**
 * Repository layer for joke entities. Implements all CRUD methods.
 */
public interface JokeRepository extends CrudRepository<Joke, Integer> {
	/**
	 * Get all jokes sorted by ID ascending.
	 *
	 * @return list of joke entities.
	 */
	Iterable<Joke> findAllByOrderByIdAsc();
}