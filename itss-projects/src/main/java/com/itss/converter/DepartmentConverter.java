package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.DepartmentTO;
import com.itss.entity.Department;
import com.itss.exception.InternalErrorException;

@Component("departmentConverter")
public class DepartmentConverter implements IConverter<Department, DepartmentTO>{

	@Override
	public Department convert(DepartmentTO transferObject) throws InternalErrorException {
		Department department = new Department();
		department.setId(transferObject.getId());
		department.setDescription(transferObject.getDescription());
		return department;
	}

	@Override
	public DepartmentTO convert(Department entity) throws InternalErrorException {
		DepartmentTO departmentTO = new DepartmentTO();
		departmentTO.setId(entity.getId());
		departmentTO.setDescription(entity.getDescription());
		return departmentTO;
	}



}
