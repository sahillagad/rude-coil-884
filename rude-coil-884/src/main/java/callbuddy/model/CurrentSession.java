package callbuddy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CurrentSession {

	@Id
    @Column(unique = true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime dateTime;

	@NotNull(message = "Please Provide Correct UserType")
	private UserType userType;
	
	
}
