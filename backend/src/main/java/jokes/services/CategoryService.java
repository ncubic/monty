package jokes.services;

import java.util.List;

import jokes.entities.Category;

/**
 * Service layer interface for categories.
 */
public interface CategoryService {
	/**
	 * List all categories.
	 *
	 * @return list of categories
	 */
	List<Category> listAll();
}