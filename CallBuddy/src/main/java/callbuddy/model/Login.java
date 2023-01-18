package callbuddy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
public class Login {


    private String email;
	private String password;
	private String userType;
	private boolean isActive;


	
	

}
