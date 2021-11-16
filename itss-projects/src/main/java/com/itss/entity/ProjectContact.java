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
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = { "project" })
@EqualsAndHashCode(exclude = { "project" })
@Table(name="PRO_PROJECTCONTACTS_T", schema = "ITSSDB")
public class ProjectContact implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IDPROCONT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="IDPROJECT")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="IDCONTACT")
	private Contact contact;
	
	
}
