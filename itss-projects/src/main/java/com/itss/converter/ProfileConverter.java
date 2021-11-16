package com.itss.converter;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.ProfileRoleTO;
import com.itss.dto.ProfileTO;
import com.itss.entity.Profile;
import com.itss.entity.ProfileRole;
import com.itss.exception.InternalErrorException;

@Component("profileConverter")
public class ProfileConverter implements IConverter<Profile, ProfileTO>{
	
	@Autowired
	private IConverter<ProfileRole, ProfileRoleTO> profileRoleConverter;

	@Override
	public Profile convert(ProfileTO transferObject) throws InternalErrorException {
		Profile profile = new Profile();
		profile.setId(transferObject.getId());
		profile.setDescription(transferObject.getDescription());
		setProfileRoles(profile, transferObject);
		return profile;
	}

	@Override
	public ProfileTO convert(Profile entity) throws InternalErrorException {
		ProfileTO profileTO = new ProfileTO();
		profileTO.setId(entity.getId());
		profileTO.setDescription(entity.getDescription());
		setProfileRoles(profileTO, entity);
		return profileTO;
	}

	
	private void setProfileRoles(ProfileTO profileTO, Profile profile) throws InternalErrorException {
		profileTO.setProfileRoles(new HashSet<>());
		for (ProfileRole profileRole : profile.getProfileRoles()) {
			profileTO.getProfileRoles().add(profileRoleConverter.convert(profileRole));
		}
	}
	
	private void setProfileRoles(Profile profile, ProfileTO profileTO) throws InternalErrorException {
		profile.setProfileRoles(new HashSet<>());
		for (ProfileRoleTO profileRole : profileTO.getProfileRoles()) {
			profile.getProfileRoles().add(profileRoleConverter.convert(profileRole));
		}
	}


}
