package com.itss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STA_EMPLOYEES_T", schema = "ITSSDB")
public class Employee implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDEMP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FIRST_NAMES")
	private String firstNames;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="emp_code")
	private String codeEmp;
	
	@ManyToOne
	@JoinColumn(name="IDDEPT")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="IDJOBTITLE")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="STATUS_CODE")
	private Status status;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="PROFILE_CODE")
	private Profile profile;
	
}
