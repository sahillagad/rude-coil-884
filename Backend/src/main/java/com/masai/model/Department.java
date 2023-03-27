package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;

	@NotNull(message = "department name cannot set as null")
	@NotEmpty(message = "department name cannot set as empty")
	@NotBlank(message = "department name cannot set as blank")
	private String departmentName;

	@NotNull(message = "department State cannot set as null")
	@NotEmpty(message = "department State cannot set as empty")
	@NotBlank(message = "department State cannot set as blank")
	private String departmentState;

	@NotNull(message = "department City cannot set as null")
	@NotEmpty(message = "department City cannot set as empty")
	@NotBlank(message = "department City cannot set as blank")
	private String departmentCity;

	@NotNull(message = "pincode cannot set as null")
	@NotEmpty(message = "pincode name cannot set as empty")
	@NotBlank(message = "pincode name cannot set as blank")
	@Size(min = 6, max = 6, message = "pincode is Must Be 6 digit")
	private String pincode;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Operator> operators = new ArrayList<>();

}
