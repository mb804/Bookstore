package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books"); // Save to database > SQL INSERT
			repository.save(new Book("The Golden Compass", "Philip Pullman", 1995, "A0123", 19.95));
			repository.save(new Book("The Subtle Knife", "Philip Pullman", 1997, "B0456", 19.95));
			
			log.info("fetch all books"); // from database > SQL SELECT
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
