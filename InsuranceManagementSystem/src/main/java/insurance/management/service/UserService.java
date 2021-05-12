package insurance.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.management.dao.UserRepository;
import insurance.management.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User saveUserRegDetails(User user) {
		
		return repo.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPasword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}

}
