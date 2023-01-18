package callbuddy.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Customer customer;
    
    
    @OneToOne
    private Problem problem;
    
    
    @ManyToOne
    private Department department;
    
    
    @ManyToOne
    private Operator operator;
    
    
    
    
    
    
    
    
	
	
	
}
