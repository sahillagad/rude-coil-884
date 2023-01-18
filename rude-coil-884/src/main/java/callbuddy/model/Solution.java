package callbuddy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer solutionId;
	private String solutionDescription;
	private LocalDate solutionDate;

	
	@OneToOne
	private Problem problem;
	
	
	
	
}
