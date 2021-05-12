package insurance.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import insurance.management.entity.Admin;

@Repository
public interface AdminRespository extends JpaRepository<Admin, Long> {

	public Admin findByEmail(String email);
	
	public Admin findByEmailAndPassword(String email, String password);
}
