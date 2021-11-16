package com.itss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="COM_STATUS_T", schema = "ITSSDB")
public class Status implements IEntity<String>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="STATUS_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name="STATUS_DESC")
	private String description;
	
}
