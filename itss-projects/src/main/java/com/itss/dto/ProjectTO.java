package com.itss.dto;

import java.util.Date;
import java.util.Set;

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
public class ProjectTO implements ITransferObject<Long> {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String numProposal;
	
	private Date openDate;
	
	private Date closeDate;
	
	private StatusTO status;
	
	private Set<ProjectContactTO> projectContacts;
	
	private Set<ProjectProductTO> projectProducts;
	
	private Set<ProjectServiceTO> projectServices;
	
	private EmployeeTO employee;
	
	private String crmNum;
	
	private Date crmDate;
	
	private String comments;

}