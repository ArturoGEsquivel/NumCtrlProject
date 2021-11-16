package com.itss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ADM_ROLES_T", schema = "ITSSDB")
public class Role implements IEntity<String>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="role_code")
	private String id;
	
	@Column(name="role_desc")
	private String description;
	
}
