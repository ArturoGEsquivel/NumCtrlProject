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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = { "employee" })
@EqualsAndHashCode(exclude = { "employee" })
@Table(name = "ADM_SECURITY_T", schema = "ITSSDB")
public class Security implements IEntity<Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idSecurity")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="IDEMP")
	private Employee employee;
	
	@Column(name="2FA")
	private Integer twoFa;
	
	@Column(name="2FA_SECRET")
	private String twoFaSecret;
	
}
