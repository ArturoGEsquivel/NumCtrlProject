package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.StatusTO;
import com.itss.entity.Status;
import com.itss.exception.InternalErrorException;

@Component("statusConverter")
public class StatusConverter implements IConverter<Status, StatusTO>{

	@Override
	public Status convert(StatusTO transferObject) throws InternalErrorException {
		Status status = new Status();
		status.setId(transferObject.getId());
		status.setDescription(transferObject.getDescription());
		return status;
	}

	@Override
	public StatusTO convert(Status entity) throws InternalErrorException {
		StatusTO statusTO = new StatusTO();
		statusTO.setId(entity.getId());
		statusTO.setDescription(entity.getDescription());
		return statusTO;
	}

}
