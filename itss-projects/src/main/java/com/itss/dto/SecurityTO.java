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
public class SecurityTO implements ITransferObject<Long> {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private EmployeeTO employee;
	
	private Integer twoFa;
	
	private String twoFaSecret;

}