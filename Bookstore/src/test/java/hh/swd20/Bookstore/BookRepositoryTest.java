package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test // Testataan BookRepositoryn findByTitle()-metodin toimivuutta
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("The Golden Compass");
		
		// Assertit osoittavat/verifioivat, toimiiko findByTitle()- metodin toimivuutta
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Philip Pullman");
	}
	
	@Test // Testataan BookRepositoryn save()-metodin toimivuutta
	public void createNewBook() {
		Book book = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, "C0732", 19.95, null);
		repository.save(book);
		
		assertThat(book.getId()).isNotNull();
	}
	
	@Test // Testataan BookRepositoryn delete()-metodin toimivuutta
	public void deleteBook() {
		repository.delete(repository.findByTitle("Murder on the Orient Express").get(0));
		List<Book> books = repository.findByTitle("Murder on the Orient Express");
		
		assertThat(books).hasSize(0);
	}
}

