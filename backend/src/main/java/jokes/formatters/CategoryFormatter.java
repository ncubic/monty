package jokes.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jokes.entities.Category;

@Component
/**
 * Category formatter used for html select tags with category object as value.
 */
public class CategoryFormatter implements Formatter<Category> {

	@Override
	/**
	 * Convert object into a string value for <option>
	 */
	public String print(Category category, Locale locale) {
		return category.getId().toString();
	}

	@Override
	/**
	 * Convert <Option> value into a Category object.
	 */
	public Category parse(String id, Locale locale) throws ParseException {
		Category cat = new Category();
		cat.setId(Integer.parseInt(id));
		return cat;
	}
}