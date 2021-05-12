package insurance.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import insurance.management.entity.Admin;
import insurance.management.service.AdminService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public Admin adminRegistration(@RequestBody Admin admin) throws Exception {
		
		String tempEmail = admin.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			Admin adminObj = adminService.fetchAdminByEmail(tempEmail);
			
			if(adminObj !=null) {
				
				throw new Exception("Admin with "+tempEmail+" is already exists");
			}
		}
		
		Admin adminObj= null;
		adminObj = adminService.saveAdminRegDetails(admin);
		return adminObj;
	}
	
	@PostMapping("/login")
	public Admin loginAdmin(@RequestBody Admin admin) throws Exception {
		
		String tempEmail = admin.getEmail();
		String tempPassword = admin.getPassword();
		Admin adminObj= null;
		
		if(tempEmail !=null & tempPassword != null) {
			adminObj = adminService.fetchAdminByEmailAndPassword(tempEmail, tempPassword);
			
			
		}
         if ( adminObj== null) {
			
			throw new Exception("Bad Credential");
		}
		
		
		return adminObj;
	}
	
	
}
