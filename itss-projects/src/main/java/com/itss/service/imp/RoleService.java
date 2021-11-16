package com.itss.service.imp;

import org.springframework.stereotype.Service;

import com.itss.converter.IConverter;
import com.itss.dto.RoleTO;
import com.itss.entity.Role;
import com.itss.repository.IRoleRepository;
import com.itss.service.IRoleService;

@Service
public class RoleService extends AbstractService<Role, RoleTO, String, IRoleRepository, IConverter<Role,RoleTO>> implements IRoleService {

}

