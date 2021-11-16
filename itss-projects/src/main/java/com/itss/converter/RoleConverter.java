package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.RoleTO;
import com.itss.entity.Role;
import com.itss.exception.InternalErrorException;

@Component("roleConverter")
public class RoleConverter implements IConverter<Role, RoleTO>{

	@Override
	public Role convert(RoleTO transferObject) throws InternalErrorException {
		Role role = new Role();
		role.setId(transferObject.getId());
		role.setDescription(transferObject.getDescription());
		return role;
	}

	@Override
	public RoleTO convert(Role entity) throws InternalErrorException {
		RoleTO roleTO = new RoleTO();
		roleTO.setId(entity.getId());
		roleTO.setDescription(entity.getDescription());
		return roleTO;
	}



}
