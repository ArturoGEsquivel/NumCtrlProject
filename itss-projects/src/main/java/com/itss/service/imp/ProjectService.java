package com.itss.service.imp;

import org.springframework.stereotype.Service;

import com.itss.converter.IConverter;
import com.itss.dto.ProjectTO;
import com.itss.entity.Project;
import com.itss.repository.IProjectRepository;
import com.itss.service.IProjectService;

@Service
public class ProjectService extends AbstractService<Project, ProjectTO, Long, IProjectRepository, IConverter<Project,ProjectTO>> implements IProjectService {

}

