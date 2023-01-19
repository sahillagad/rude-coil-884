package callbuddy.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class Call {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer callId;
	private String mobile;
	private LocalDate date;
    private LocalTime time;
//  private String duration;
    
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
    
    
    @OneToOne(mappedBy= "call", cascade = CascadeType.ALL)
    private Problem problem;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="deptId")
    private Department department;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="opId")
    private Operator operator;
    

}
