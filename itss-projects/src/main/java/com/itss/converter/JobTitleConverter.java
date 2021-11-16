package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.JobTitleTO;
import com.itss.entity.JobTitle;
import com.itss.exception.InternalErrorException;

@Component("jobTitleConverter")
public class JobTitleConverter implements IConverter<JobTitle, JobTitleTO>{

	@Override
	public JobTitle convert(JobTitleTO transferObject) throws InternalErrorException {
		JobTitle jobTitle = new JobTitle();
		jobTitle.setId(transferObject.getId());
		jobTitle.setDescription(transferObject.getDescription());
		return jobTitle;
	}

	@Override
	public JobTitleTO convert(JobTitle entity) throws InternalErrorException {
		JobTitleTO jobTitleTO = new JobTitleTO();
		jobTitleTO.setId(entity.getId());
		jobTitleTO.setDescription(entity.getDescription());
		return jobTitleTO;
	}



}
