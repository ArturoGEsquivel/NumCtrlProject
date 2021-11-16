package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.ProfileRoleTO;
import com.itss.dto.ProfileTO;
import com.itss.dto.RoleTO;
import com.itss.entity.Profile;
import com.itss.entity.ProfileRole;
import com.itss.entity.Role;
import com.itss.exception.InternalErrorException;

@Component("profileRoleConverter")
public class ProfileRoleConverter implements IConverter<ProfileRole, ProfileRoleTO>{
	
	@Autowired
	private IConverter<Role, RoleTO> roleConverter;
	
	@Override
	public ProfileRole convert(ProfileRoleTO transferObject) throws InternalErrorException {
		
		Profile profile = new Profile();
		profile.setId(transferObject.getProfile().getId());
		
		ProfileRole profileRole = new ProfileRole();
		profileRole.setId(transferObject.getId());
		profileRole.setProfile(profile);
		
		if(Objects.nonNull(transferObject.getRole())) 
			profileRole.setRole(roleConverter.convert(transferObject.getRole()));
		
		return profileRole;
	}

	@Override
	public ProfileRoleTO convert(ProfileRole entity) throws InternalErrorException {
		
		ProfileRoleTO profileRoleTO = new ProfileRoleTO();
		profileRoleTO.setId(entity.getId());
		
		ProfileTO profile = new ProfileTO();
		profile.setId(entity.getProfile().getId());
		profileRoleTO.setProfile(profile);
		
		if(Objects.nonNull(entity.getRole())) 
			profileRoleTO.setRole(roleConverter.convert(entity.getRole()));
		
		return profileRoleTO;
	}

}
