package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.ServiceTO;
import com.itss.entity.Service;
import com.itss.exception.InternalErrorException;

@Component("serviceConverter")
public class ServiceConverter implements IConverter<Service, ServiceTO>{

	@Override
	public Service convert(ServiceTO transferObject) throws InternalErrorException {
		Service service = new Service();
		service.setId(transferObject.getId());
		service.setDescription(transferObject.getDescription());
		service.setIsITSC(transferObject.getIsITSC());
		return service;
	}

	@Override
	public ServiceTO convert(Service entity) throws InternalErrorException {
		ServiceTO serviceTO = new ServiceTO();
		serviceTO.setId(entity.getId());
		serviceTO.setDescription(entity.getDescription());
		serviceTO.setIsITSC(entity.getIsITSC());
		return serviceTO;
	}



}
