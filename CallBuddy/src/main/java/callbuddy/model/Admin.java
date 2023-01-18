package callbuddy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Admin {

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AdminId;
	private String name;
	private String email;
	private String mobile;
	private String city;
	
	
	
	
}
