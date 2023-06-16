package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@NotNull(message = "user name cannot set as null")
	@NotEmpty(message = "user name cannot set as empty")
	@NotBlank(message = "user name cannot set as blank")
//    @Column(unique = true)
	private String userName;

	@NotNull(message = "password cannot set as null")
	@NotEmpty(message = "password cannot set as empty")
	@NotBlank(message = "password cannot set as blank")
	private String password;

	@NotNull(message = "name cannot set as null")
	@NotEmpty(message = "name cannot set as empty")
	@NotBlank(message = "name cannot set as blank")
	private String name;

	/*
	 * ^ #Match the beginning of the string [789] #Match a 7, 8 or 9 \d #Match a
	 * digit (0-9 and anything else that is a "digit" in the regex engine) {9}
	 * #Repeat the previous "\d" 9 times (9 digits) $ #Match the end of the string
	 * 
	 */

	@NotNull(message = "mobile cannot set as null")
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobile;

	@Column(unique = true)
	@Email(message = "email format is incorrect")
	private String email;

	private String customerStatus;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Calling> calls = new ArrayList<>();

}
