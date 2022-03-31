package hh.swd20.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username); // Must
	
	List<User> findByRole(String role);
	
	List<User> findByUsers(String username);
	
}
