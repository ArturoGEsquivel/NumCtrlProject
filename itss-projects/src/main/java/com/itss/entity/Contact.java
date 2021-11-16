package com.itss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="PRO_CONTACTS_T", schema = "ITSSDB")
public class Contact implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="IDCONTACT")
	private Long id;
	
	@Column(name="FIRST_NAMES")
	private String firstNames;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TYPE_CONTACT")
	private String typeContact;
	
}
