package com.itss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="PRO_PROJECTHISTORY_T", schema = "ITSSDB")
public class History implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="IDHISTORY")
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="IDPROJECT")
	private Project project;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "IDSTATUS")
	private Status status;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="COMMENTS")
	private Integer comments;
	
}
