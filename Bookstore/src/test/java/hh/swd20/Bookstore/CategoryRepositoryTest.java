package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test // Testaan find()-metodin toimivuutta
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Fantasy");
		
		// Assertit osoittavat/verifioivat, toimiiko findByName()- metodin toimivuutta
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
	}
	
	@Test // Testataan CategoryRepositoryn save()-metodin toimivuutta
	public void createNewCategory() {
		Category category = new Category("Mystery");
		repository.save(category);
		
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test // Testataan delete()-metodin toimivuutta
	public void deleteCategory() {
		repository.delete(repository.findByName("Fantasy").get(0));
		List<Category> categories = repository.findByName("Fantasy");
		
		assertThat(categories).hasSize(0);
	}
}
