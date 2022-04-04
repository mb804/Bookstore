package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test // Testaan find()-metodin toimivuutta
	public void findByRoleShouldReturnUser() {
		List<User> users = repository.findByRole("USER");
		
		// Assertit osoittavat/verifioivat, toimiiko findByRole()- metodin toimivuutta
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("user");
	}
	
	@Test // Testataan UserRepositoryn save()-metodin toimivuutta
	public void createNewUser() {
		User user = new User("staff", "$2a$10$2MnCl0q56uFClh7O4GnXm.oMjRuxeiqWgiMkIKtGw6d4.DDDmwCWK", "staff@email.com", "STAFF");
		repository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}
	
	@Test // Testataan delete()-metodin toimivuutta
	public void deleteUser() {
		repository.delete(repository.findByUsername("user"));
		User user = repository.findByUsername("user");
		
		assertThat(user).isNull();
	}
}
