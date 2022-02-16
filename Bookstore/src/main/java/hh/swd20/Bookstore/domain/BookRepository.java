package hh.swd20.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	// BookRepository perii CrudRepositorylta
	// findAll(), findById(), save(), deleteById() yms.

}
