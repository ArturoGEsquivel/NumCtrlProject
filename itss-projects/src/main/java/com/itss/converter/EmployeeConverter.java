package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.DepartmentTO;
import com.itss.dto.EmployeeTO;
import com.itss.dto.JobTitleTO;
import com.itss.dto.ProfileTO;
import com.itss.dto.StatusTO;
import com.itss.entity.Department;
import com.itss.entity.Employee;
import com.itss.entity.JobTitle;
import com.itss.entity.Profile;
import com.itss.entity.Status;
import com.itss.exception.InternalErrorException;

@Component("employeeConverter")
public class EmployeeConverter implements IConverter<Employee, EmployeeTO>{
	
	@Autowired
	private IConverter<Department, DepartmentTO> departmentConverter;
	
	@Autowired
	private IConverter<JobTitle, JobTitleTO> jobTitleConverter;
	
	@Autowired
	private IConverter<Status, StatusTO> statusConverter;
	
	@Autowired
	private IConverter<Profile, ProfileTO> profileConverter;
	

	@Override
	public Employee convert(EmployeeTO transferObject) throws InternalErrorException {
		Employee employee = new Employee();
		employee.setId(transferObject.getId());
		employee.setCodeEmp(transferObject.getCodeEmp());
		employee.setFirstNames(transferObject.getFirstNames());
		employee.setLastname(transferObject.getLastname());
		employee.setSurname(transferObject.getSurname());
		employee.setPassword(transferObject.getPassword());
		employee.setUsername(transferObject.getUsername());
		
		if(Objects.nonNull(transferObject.getStatus())) 
			employee.setStatus(statusConverter.convert(transferObject.getStatus()));
		
		if(Objects.nonNull(transferObject.getDepartment())) 
			employee.setDepartment(departmentConverter.convert(transferObject.getDepartment()));
		
		if(Objects.nonNull(transferObject.getJobTitle())) 
			employee.setJobTitle(jobTitleConverter.convert(transferObject.getJobTitle()));

		if(Objects.nonNull(transferObject.getProfile())) 
			employee.setProfile(profileConverter.convert(transferObject.getProfile()));

		return employee;
	}

	@Override
	public EmployeeTO convert(Employee entity) throws InternalErrorException {
		EmployeeTO employeeTO = new EmployeeTO();
		
		employeeTO.setId(entity.getId());
		employeeTO.setCodeEmp(entity.getCodeEmp());
		employeeTO.setFirstNames(entity.getFirstNames());
		employeeTO.setLastname(entity.getLastname());
		employeeTO.setSurname(entity.getSurname());
		employeeTO.setPassword(entity.getPassword());
		employeeTO.setUsername(entity.getUsername());
		
		if(Objects.nonNull(entity.getStatus())) 
			employeeTO.setStatus(statusConverter.convert(entity.getStatus()));
		
		if(Objects.nonNull(entity.getDepartment())) 
			employeeTO.setDepartment(departmentConverter.convert(entity.getDepartment()));
		
		if(Objects.nonNull(entity.getJobTitle())) 
			employeeTO.setJobTitle(jobTitleConverter.convert(entity.getJobTitle()));

		if(Objects.nonNull(entity.getProfile())) 
			employeeTO.setProfile(profileConverter.convert(entity.getProfile()));

		return employeeTO;
	}



}
