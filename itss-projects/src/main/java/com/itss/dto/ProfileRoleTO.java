package com.itss.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itss.entity.IEntity;

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
public class ProfileRoleTO implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ProfileTO profile;
	
	private RoleTO role;
	
}
