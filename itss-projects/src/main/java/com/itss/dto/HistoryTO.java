package com.itss.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryTO implements ITransferObject<Long> {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private ProjectTO project;
	
	private StatusTO status;
	
	private Date date;
	
	private Integer comments;

}