package jokes.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jokes.repositories.JokeRepository;
import jokes.entities.Joke;

@Service
/**
 * Implementation of joke service.
 */
public class JokeServiceImpl implements JokeService {

	@Autowired
	private JokeRepository jokeRepository;

	/**
	 * List all jokes.
	 *
	 * @return list of jokes.
	 */
	public List<Joke> listAll() {
		List<Joke> jokes = new ArrayList<Joke>();
		this.jokeRepository.findAllByOrderByIdAsc().forEach(joke -> jokes.add(joke));
		return jokes;
	}

	/**
	 * Insert new joke.
	 *
	 * @param joke
	 */
	public void insert(Joke joke) {
		this.jokeRepository.save(joke);
	}

	/**
	 * Update existing joke.
	 *
	 * @param joke
	 */
	public void update(Joke joke) {
		this.jokeRepository.save(joke);
	}

	/**
	 * Find joke by id.
	 *
	 * @param id
	 * @return Optional object with joke.
	 */
	public Optional<Joke> find(Integer id) {
		return this.jokeRepository.findById(id);
	}
}