package insurance.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="policy")
@Data
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long policyId;
	
	@Column(name="policy_type")
	private String policyType;
	
	@Column(name="policy_name")
	private String policyName;
	
	@Column(name="sum_assured")
	private Long sumAssured;
	
	@Column(name="premium")
	private Long premium;
	
	@Column(name="tenure")
	private int tenure;
	
	

}
