package hh.swd20.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	// CategoryRepository perii CrudRepositorylta
	// findAll(), findById(), save(), deleteById() yms.
	
	List<Category> findByName(String name);
	
}
