package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.ContactTO;
import com.itss.dto.ProjectContactTO;
import com.itss.dto.ProjectTO;
import com.itss.entity.Contact;
import com.itss.entity.Project;
import com.itss.entity.ProjectContact;
import com.itss.exception.InternalErrorException;

@Component("projectContactConverter")
public class ProjectContactConverter implements IConverter<ProjectContact, ProjectContactTO>{
	
	@Autowired
	private IConverter<Project, ProjectTO> projectConverter;
	
	@Autowired
	private IConverter<Contact, ContactTO> contactConverter;
	
	@Override
	public ProjectContact convert(ProjectContactTO transferObject) throws InternalErrorException {
		
		ProjectContact projectContact = new ProjectContact();
		projectContact.setId(transferObject.getId());
		
		
		if(Objects.nonNull(transferObject.getContact())) 
			projectContact.setContact(contactConverter.convert(transferObject.getContact()));
		
		if(Objects.nonNull(transferObject.getProject())) 
			projectContact.setProject(projectConverter.convert(transferObject.getProject()));
		
		return projectContact;
	}

	@Override
	public ProjectContactTO convert(ProjectContact entity) throws InternalErrorException {
		
		ProjectContactTO projectContactTO = new ProjectContactTO();
		projectContactTO.setId(entity.getId());
		
		
		if(Objects.nonNull(entity.getContact())) 
			projectContactTO.setContact(contactConverter.convert(entity.getContact()));
		
		if(Objects.nonNull(entity.getProject())) 
			projectContactTO.setProject(projectConverter.convert(entity.getProject()));
		
		return projectContactTO;
	}

}
