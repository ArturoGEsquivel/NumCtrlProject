package com.itss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = { "profile" })
@EqualsAndHashCode(exclude = { "profile" })
@Table(name="ADM_PROFILEROLES_T", schema = "ITSSDB")
public class ProfileRole implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	/** Unique identifier. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRFLROLE")
	private Long id;
	
	/** The profile. */
	// bi-directional many-to-one association to CProfileT
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILE_CODE")
	private Profile profile;
	
	/** The role. */
	// bi-directional many-to-one association to CRoleT
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_CODE")
	private Role role;
	
}
