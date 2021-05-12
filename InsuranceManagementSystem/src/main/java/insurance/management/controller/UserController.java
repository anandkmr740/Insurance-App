package insurance.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import insurance.management.entity.User;
import insurance.management.service.UserService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/userRegister")
	public User userRegistration(@RequestBody User user) throws Exception {
		
		String tempEmail = user.getEmail();
		
		if(tempEmail != null && !"".equals(tempEmail)){
			User userObj = userService.fetchUserByEmail(tempEmail);
			
			if(userObj != null) {
				throw new Exception("User with "+tempEmail+" is already exists !");
			}
		}
		
		User userObj=null;
		
		userObj= userService.saveUserRegDetails(user);
		
		return userObj;
	}
	
	@PostMapping("/userLogin")
	public User userLogin(@RequestBody User user) throws Exception {
	
	String tempEmail = user.getEmail();
	String tempPassword = user.getPassword();
	User userObj=null;
	
	if(tempEmail != null && tempPassword != null) {
		userObj = userService.fetchUserByEmailAndPasword(tempEmail, tempPassword);
	}
	
	if(userObj == null) {
		throw new Exception("Bad Credential");
	}
	
	return userObj;
}
}
