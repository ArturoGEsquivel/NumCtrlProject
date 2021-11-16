package com.itss.dto;

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
public class ProfileTO implements ITransferObject<String> {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String description;
	
	private Set<ProfileRoleTO> profileRoles;
	
}