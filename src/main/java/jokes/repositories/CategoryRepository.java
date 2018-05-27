package jokes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import jokes.entities.Category;

@Repository
/**
 * Repository layer for categories.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	/**
	 * Get all categories from database.
	 * @return list of categories.
	 */
	List<Category> findAll();
}