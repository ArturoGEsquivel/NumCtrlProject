package com.itss.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="PRO_PROJECTS_T", schema = "ITSSDB")
public class Project implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDPROJECT")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@Column(name="NO_PROPOSAL")
	private String numProposal;
	
	@Column(name="OPEN_DATE")
	private Date openDate;
	
	@Column(name="CLOSE_DATE")
	private Date closeDate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "STATUS_CODE")
	private Status status;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="project")
	private Set<ProjectContact> projectContacts = new HashSet<>();
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="project")
	private Set<ProjectProduct> projectProducts = new HashSet<>();
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="project")
	private Set<ProjectService> projectServices = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="IDEMP")
	private Employee employee;
	
	@Column(name="CRM_NUMBER")
	private String crmNum;
	
	@Column(name="CRM_DATE")
	private Date crmDate;
	
	@Column(name="COMMENTS")
	private String comments;
	
}
