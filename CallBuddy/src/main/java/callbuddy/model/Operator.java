package callbuddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  operatorId;
	private String name;
	private String email;
	private String mobile;
	private String city;
	private String state;
	private String pincode;
	private boolean active=true;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deptId")
	private Department department;
	
	
	@OneToMany(mappedBy = "operator",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Call> calls=new ArrayList<>();
	
	
}
