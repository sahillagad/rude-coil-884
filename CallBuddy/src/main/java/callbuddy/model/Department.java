package callbuddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer departmentId;
	private String departmentName;
   
	
	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Operator> operators=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Call> calls=new ArrayList<>();
	
	
	
	
	
}
