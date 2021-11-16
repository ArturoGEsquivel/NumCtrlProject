package com.itss.converter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itss.dto.CurrencyUnitTO;
import com.itss.dto.ProductTO;
import com.itss.dto.ProjectProductTO;
import com.itss.dto.ProjectTO;
import com.itss.entity.CurrencyUnit;
import com.itss.entity.Product;
import com.itss.entity.Project;
import com.itss.entity.ProjectProduct;
import com.itss.exception.InternalErrorException;

@Component("projectProductConverter")
public class ProjectProductConverter implements IConverter<ProjectProduct, ProjectProductTO>{
	
	@Autowired
	private IConverter<Project, ProjectTO> projectConverter;
	
	@Autowired
	private IConverter<Product, ProductTO> productConverter;
	
	@Autowired
	private IConverter<CurrencyUnit, CurrencyUnitTO> currencyUnitConverter;

	@Override
	public ProjectProduct convert(ProjectProductTO transferObject) throws InternalErrorException {
		
		ProjectProduct profileRole = new ProjectProduct();
		profileRole.setId(transferObject.getId());
		profileRole.setAmount(transferObject.getAmount());
		profileRole.setQuantity(transferObject.getQuantity());
		
		if(Objects.nonNull(transferObject.getCurrencyUnit())) 
			profileRole.setCurrencyUnit(currencyUnitConverter.convert(transferObject.getCurrencyUnit()));
		
		if(Objects.nonNull(transferObject.getProduct())) 
			profileRole.setProduct(productConverter.convert(transferObject.getProduct()));
		
		if(Objects.nonNull(transferObject.getProject())) 
			profileRole.setProject(projectConverter.convert(transferObject.getProject()));
		
		return profileRole;
	}

	@Override
	public ProjectProductTO convert(ProjectProduct entity) throws InternalErrorException {
		
		ProjectProductTO projectProductTO = new ProjectProductTO();
		projectProductTO.setId(entity.getId());
		
		if(Objects.nonNull(entity.getCurrencyUnit())) 
			projectProductTO.setCurrencyUnit(currencyUnitConverter.convert(entity.getCurrencyUnit()));
		
		if(Objects.nonNull(entity.getProduct())) 
			projectProductTO.setProduct(productConverter.convert(entity.getProduct()));
		
		if(Objects.nonNull(entity.getProject())) 
			projectProductTO.setProject(projectConverter.convert(entity.getProject()));
		
		return projectProductTO;
	}

}
