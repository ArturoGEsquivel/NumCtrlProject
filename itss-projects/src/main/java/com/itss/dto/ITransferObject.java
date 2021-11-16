package com.itss.dto;

import java.io.Serializable;

public interface ITransferObject<ID extends Serializable> extends Serializable {

	ID getId();
	
	void setId(ID id);
	
}
