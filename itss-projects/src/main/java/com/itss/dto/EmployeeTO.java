package com.itss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeTO implements ITransferObject<Long> {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String firstNames;
	
	private String lastname;
	
	private String surname;
	
	private String codeEmp;
	
	private String username;
	
	private String password;
	
	private ProfileTO profile;
	
	private DepartmentTO department;
	
	private JobTitleTO jobTitle;
	
	private StatusTO status;

}