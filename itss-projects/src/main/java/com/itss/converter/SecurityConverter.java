package com.itss.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.EmployeeTO;
import com.itss.dto.SecurityTO;
import com.itss.entity.Employee;
import com.itss.entity.Security;
import com.itss.exception.InternalErrorException;

@Component("securityConverter")
public class SecurityConverter implements IConverter<Security, SecurityTO> {
	
	@Autowired
	private IConverter<Employee, EmployeeTO> employeeConverter;

	@Override
	public Security convert(SecurityTO transferObject) throws InternalErrorException {
		Security security = new Security();
		security.setId(transferObject.getId());
		security.setTwoFa(transferObject.getTwoFa());
		security.setTwoFaSecret(transferObject.getTwoFaSecret());
		security.setEmployee(employeeConverter.convert(transferObject.getEmployee()));
		return security;
	}

	@Override
	public SecurityTO convert(Security entity) throws InternalErrorException {
		SecurityTO securityTO = new SecurityTO();
		securityTO.setId(entity.getId());
		securityTO.setTwoFa(entity.getTwoFa());
		securityTO.setTwoFaSecret(entity.getTwoFaSecret());
		securityTO.setEmployee(employeeConverter.convert(entity.getEmployee()));
		return securityTO;
	}



}
