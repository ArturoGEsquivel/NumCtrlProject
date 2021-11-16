package com.itss.converter;

import java.util.HashSet;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.EmployeeTO;
import com.itss.dto.ProjectContactTO;
import com.itss.dto.ProjectProductTO;
import com.itss.dto.ProjectServiceTO;
import com.itss.dto.ProjectTO;
import com.itss.dto.StatusTO;
import com.itss.entity.Employee;
import com.itss.entity.Project;
import com.itss.entity.ProjectContact;
import com.itss.entity.ProjectProduct;
import com.itss.entity.ProjectService;
import com.itss.entity.Status;
import com.itss.exception.InternalErrorException;

@Component("projectConverter")
public class ProjectConverter implements IConverter<Project, ProjectTO>{

	@Autowired
	private IConverter<ProjectProduct, ProjectProductTO> projectProductsConverter;
	
	@Autowired
	private IConverter<ProjectService, ProjectServiceTO> projectServicesConverter;
	
	@Autowired
	private IConverter<ProjectContact, ProjectContactTO> projectContactConverter;

	@Autowired
	private IConverter<Employee, EmployeeTO> employeeConverter;
	
	@Autowired
	private IConverter<Status, StatusTO> statusConverter;
	
	@Override
	public Project convert(ProjectTO transferObject) throws InternalErrorException {
		Project project = new Project();
		project.setId(transferObject.getId());
		project.setCloseDate(transferObject.getCloseDate());
		project.setComments(transferObject.getComments());
		project.setCrmDate(transferObject.getCrmDate());
		project.setCrmNum(transferObject.getCrmNum());
		project.setNumProposal(transferObject.getNumProposal());
		project.setOpenDate(transferObject.getOpenDate());
		
		if(Objects.nonNull(transferObject.getStatus())) 
			project.setStatus(statusConverter.convert(transferObject.getStatus()));
		
		if(Objects.nonNull(transferObject.getEmployee())) 
			project.setEmployee(employeeConverter.convert(transferObject.getEmployee()));
		
		setProjectProducts(project, transferObject);
		setProjectServices(project, transferObject);
		setProjectContacts(project, transferObject);
		
		return project;
	}

	@Override
	public ProjectTO convert(Project entity) throws InternalErrorException {
		ProjectTO projectTO = new ProjectTO();
		projectTO.setId(entity.getId());
		projectTO.setCloseDate(entity.getCloseDate());
		projectTO.setComments(entity.getComments());
		projectTO.setCrmDate(entity.getCrmDate());
		projectTO.setCrmNum(entity.getCrmNum());
		projectTO.setNumProposal(entity.getNumProposal());
		projectTO.setOpenDate(entity.getOpenDate());
		
		if(Objects.nonNull(entity.getStatus())) 
			projectTO.setStatus(statusConverter.convert(entity.getStatus()));
		
		if(Objects.nonNull(entity.getEmployee())) 
			projectTO.setEmployee(employeeConverter.convert(entity.getEmployee()));
		
		setProjectProducts(projectTO, entity);
		setProjectServices(projectTO, entity);
		setProjectContacts(projectTO, entity);
		
		return projectTO;
	}

	private void setProjectProducts(ProjectTO projectTO, Project project) throws InternalErrorException {
		projectTO.setProjectProducts(new HashSet<>());
		for (ProjectProduct projectProduct : project.getProjectProducts()) {
			projectTO.getProjectProducts().add(projectProductsConverter.convert(projectProduct));
		}
	}
	
	private void setProjectProducts(Project project, ProjectTO projectTO) throws InternalErrorException {
		project.setProjectProducts(new HashSet<>());
		for (ProjectProductTO projectProduct : projectTO.getProjectProducts()) {
			project.getProjectProducts().add(projectProductsConverter.convert(projectProduct));
		}
	}
	
	private void setProjectServices(ProjectTO projectTO, Project project) throws InternalErrorException {
		projectTO.setProjectServices(new HashSet<>());
		for (ProjectService projectService : project.getProjectServices()) {
			projectTO.getProjectServices().add(projectServicesConverter.convert(projectService));
		}
	}
	
	private void setProjectServices(Project project, ProjectTO projectTO) throws InternalErrorException {
		project.setProjectServices(new HashSet<>());
		for (ProjectServiceTO projectService : projectTO.getProjectServices()) {
			project.getProjectServices().add(projectServicesConverter.convert(projectService));
		}
	}
	
	private void setProjectContacts(ProjectTO projectTO, Project project) throws InternalErrorException {
		projectTO.setProjectContacts(new HashSet<>());
		for (ProjectContact projectContact : project.getProjectContacts()) {
			projectTO.getProjectContacts().add(projectContactConverter.convert(projectContact));
		}
	}
	
	private void setProjectContacts(Project project, ProjectTO projectTO) throws InternalErrorException {
		project.setProjectContacts(new HashSet<>());
		for (ProjectContactTO projectContact : projectTO.getProjectContacts()) {
			project.getProjectContacts().add(projectContactConverter.convert(projectContact));
		}
	}

}
