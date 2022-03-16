package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of books"); // Save to database > SQL INSERT
			// CategoryRepository
			Category category1 = new Category("Action and Adventure");
			categoryRepository.save(category1);
			Category category2 = new Category("Detective and Mystery");
			categoryRepository.save(category2);
			Category category3 = new Category("Fantasy");
			categoryRepository.save(category3);
			
			log.info("fetch all categories"); // from database > SQL SELECT
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			// BookRepository
			bookRepository.save(new Book("The Golden Compass", "Philip Pullman", 1995, "A0123", 19.95, category1));
			bookRepository.save(new Book("The Subtle Knife", "Philip Pullman", 1997, "A0456", 19.95, category1));
			bookRepository.save(new Book("Murder on the Orient Express", "Agatha Christie", 1934, "B0789", 12.95, category2));
			bookRepository.save(new Book("Skulduggery Pleasant", "Derek Landy", 2007, "C0832", 8.95, category3));
			
			// Users: admin/admin user/user
			User user1 = new User("user","$2a$10$d92Fxugbjr3iK2Sjs8dWaenudJ3mFs83FtXtunEAQzWxqdV6BlRJC", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$urRfgFp2RhQVh6wIZQ16R.70KKdrzoBuCqsDc8JmVEB5ca97e3lKu", "admin@email.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all books"); // from database > SQL SELECT
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
