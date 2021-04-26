package insurance.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import insurance.management.dao.PolicyRepository;
import insurance.management.entity.Policy;
import insurance.management.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyController {
	
	@Autowired
	private  PolicyRepository policyRepository;
	
	@GetMapping("/policies")
	public List<Policy> getAllPolicies(){
		return policyRepository.findAll();
	}
	
	@PostMapping("/policies")
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyRepository.save(policy);
	}
	
	@GetMapping("/policies/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Long id){
		
		Policy policy = policyRepository.findById(id).orElseThrow();
		
		return ResponseEntity.ok(policy);
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<Policy> updatePolicy (@PathVariable Long id, @RequestBody Policy policyDetails){
		
		Policy policy = policyRepository.findById(id).orElseThrow();
		
		policy.setPolicyType(policyDetails.getPolicyType());
		policy.setPolicyName(policyDetails.getPolicyName());
		policy.setPremium(policyDetails.getPremium());
		policy.setSumAssured(policyDetails.getSumAssured());
		policy.setTenure(policyDetails.getTenure());
		
		Policy updatePolicy = policyRepository.save(policy);
		
		return ResponseEntity.ok(updatePolicy);
		
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<Map<String, Boolean>>deletePolicy(@PathVariable Long id){
		
		Policy policy = policyRepository.findById(id).orElseThrow();
		
		policyRepository.delete(policy);
		Map<String, Boolean> response = new HashMap<>();	
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

}
