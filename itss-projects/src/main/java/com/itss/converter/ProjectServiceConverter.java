package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.CurrencyUnitTO;
import com.itss.dto.ProjectServiceTO;
import com.itss.dto.ProjectTO;
import com.itss.dto.ServiceTO;
import com.itss.entity.CurrencyUnit;
import com.itss.entity.Project;
import com.itss.entity.ProjectService;
import com.itss.entity.Service;
import com.itss.exception.InternalErrorException;

@Component("projectServiceConverter")
public class ProjectServiceConverter implements IConverter<ProjectService, ProjectServiceTO>{
	
	@Autowired
	private IConverter<Service, ServiceTO> serviceConverter;
	
	@Autowired
	private IConverter<Project, ProjectTO> projectConverter;
	
	@Autowired
	private IConverter<CurrencyUnit, CurrencyUnitTO> currencyUnitConverter;

	@Override
	public ProjectService convert(ProjectServiceTO transferObject) throws InternalErrorException {
		
		ProjectService projectService = new ProjectService();
		projectService.setId(transferObject.getId());
		projectService.setAmount(transferObject.getAmount());
		projectService.setQuantity(transferObject.getQuantity());
		
		if(Objects.nonNull(transferObject.getCurrencyUnit())) 
			projectService.setCurrencyUnit(currencyUnitConverter.convert(transferObject.getCurrencyUnit()));
		
		if(Objects.nonNull(transferObject.getService())) 
			projectService.setService(serviceConverter.convert(transferObject.getService()));
		
		if(Objects.nonNull(transferObject.getProject())) 
			projectService.setProject(projectConverter.convert(transferObject.getProject()));
		
		return projectService;
	}

	@Override
	public ProjectServiceTO convert(ProjectService entity) throws InternalErrorException {
		
		ProjectServiceTO projectServiceTO = new ProjectServiceTO();
		projectServiceTO.setId(entity.getId());
		projectServiceTO.setAmount(entity.getAmount());
		projectServiceTO.setQuantity(entity.getQuantity());
		
		if(Objects.nonNull(entity.getCurrencyUnit())) 
			projectServiceTO.setCurrencyUnit(currencyUnitConverter.convert(entity.getCurrencyUnit()));
		
		if(Objects.nonNull(entity.getService())) 
			projectServiceTO.setService(serviceConverter.convert(entity.getService()));
		
		if(Objects.nonNull(entity.getProject())) 
			projectServiceTO.setProject(projectConverter.convert(entity.getProject()));
		
		return projectServiceTO;
	}

}
