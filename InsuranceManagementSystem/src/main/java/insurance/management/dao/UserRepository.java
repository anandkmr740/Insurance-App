package insurance.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import insurance.management.entity.User;

public interface UserRepository extends JpaRepository< User, Long> {

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String pasword);
	
}
