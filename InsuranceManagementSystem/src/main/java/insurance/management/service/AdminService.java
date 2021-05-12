package insurance.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import insurance.management.dao.AdminRespository;
import insurance.management.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminRespository repo;
	
	public Admin saveAdminRegDetails(Admin admin) {
		
		return repo.save(admin);
	}

	public Admin fetchAdminByEmail(String email) {
		
		return repo.findByEmail(email);
	}
	
public Admin fetchAdminByEmailAndPassword(String email, String password) {
		
		return repo.findByEmailAndPassword(email, password);
	}
}
