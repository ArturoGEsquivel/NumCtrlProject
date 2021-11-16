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
@Table(name="COM_SERVICES_T", schema = "ITSSDB")
public class Service implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDSERVICE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SERV_DESC")
	private String description;
	
	@Column(name="NOTE")
	private String note;
	
	@Column(name="ITSC")
	private Boolean isITSC;
	
}
