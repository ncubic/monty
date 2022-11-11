package jokes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jokes.repositories.CategoryRepository;
import jokes.entities.Category;

@Service
/**
 * Implementation of category service.
 */
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * List all categories.
	 *
	 * @return list of categories
	 */
	public List<Category> listAll() {
		return this.categoryRepository.findAll();
	}
}