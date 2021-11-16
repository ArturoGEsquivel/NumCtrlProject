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
@Table(name="COM_PRODUCTS_T", schema = "ITSSDB")
public class Product implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPRODUCT")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="PROD_DESC")
	private String description;
	
	
}
