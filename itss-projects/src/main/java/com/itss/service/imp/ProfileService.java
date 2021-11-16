package com.itss.service.imp;

import org.springframework.stereotype.Service;

import com.itss.converter.IConverter;
import com.itss.dto.ProfileTO;
import com.itss.entity.Profile;
import com.itss.repository.IProfileRepository;
import com.itss.service.IProfileService;

@Service
public class ProfileService extends AbstractService<Profile, ProfileTO, String, IProfileRepository, IConverter<Profile,ProfileTO>> implements IProfileService {

}

