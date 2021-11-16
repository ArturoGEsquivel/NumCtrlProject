package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.HistoryTO;
import com.itss.dto.ProjectTO;
import com.itss.dto.StatusTO;
import com.itss.entity.History;
import com.itss.entity.Project;
import com.itss.entity.Status;
import com.itss.exception.InternalErrorException;

@Component("historyConverter")
public class HistoryConverter implements IConverter<History, HistoryTO> {
	
	@Autowired
	private IConverter<Status, StatusTO> statusConverter;
	
	@Autowired
	private IConverter<Project, ProjectTO> projectConverter;

	@Override
	public History convert(HistoryTO transferObject) throws InternalErrorException {
		History history = new History();
		history.setId(transferObject.getId());
		history.setDate(transferObject.getDate());
		history.setComments(transferObject.getComments());
		
		if(Objects.nonNull(transferObject.getStatus())) 
			history.setStatus(statusConverter.convert(transferObject.getStatus()));
		
		if(Objects.nonNull(transferObject.getProject())) 
			history.setProject(projectConverter.convert(transferObject.getProject()));
		
		return history;
	}

	@Override
	public HistoryTO convert(History entity) throws InternalErrorException {
		HistoryTO historyTO = new HistoryTO();
		historyTO.setId(entity.getId());
		historyTO.setDate(entity.getDate());
		historyTO.setComments(entity.getComments());
		
		if(Objects.nonNull(entity.getStatus())) 
			historyTO.setStatus(statusConverter.convert(entity.getStatus()));
		
		if(Objects.nonNull(entity.getProject())) 
			historyTO.setProject(projectConverter.convert(entity.getProject()));
		return historyTO;
	}



}
