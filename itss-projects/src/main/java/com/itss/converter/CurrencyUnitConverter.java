package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.CurrencyUnitTO;
import com.itss.entity.CurrencyUnit;
import com.itss.exception.InternalErrorException;

@Component("currencyUnitConverter")
public class CurrencyUnitConverter implements IConverter<CurrencyUnit, CurrencyUnitTO>{

	@Override
	public CurrencyUnit convert(CurrencyUnitTO transferObject) throws InternalErrorException {
		CurrencyUnit currencyUnit = new CurrencyUnit();
		currencyUnit.setId(transferObject.getId());
		currencyUnit.setDescription(transferObject.getDescription());
		return currencyUnit;
	}

	@Override
	public CurrencyUnitTO convert(CurrencyUnit entity) throws InternalErrorException {
		CurrencyUnitTO currencyUnitTO = new CurrencyUnitTO();
		currencyUnitTO.setId(entity.getId());
		currencyUnitTO.setDescription(entity.getDescription());
		return currencyUnitTO;
	}



}
