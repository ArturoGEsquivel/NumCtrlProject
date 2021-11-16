package com.itss.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ADM_PROFILES_T", schema = "ITSSDB")
public class Profile implements IEntity<String>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PROFILE_CODE")
	private String id;
	
	@Column(name="PROF_DESC")
	private String description;
	
	/** The profile roles. */
	// bi-directional many-to-one association to MPrflRoleT
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProfileRole> profileRoles;

	
}
