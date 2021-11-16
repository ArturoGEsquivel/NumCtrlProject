package com.itss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.NoSuchMessageException;

import com.itss.dto.ITransferObject;
import com.itss.exception.DataNotFoundException;
import com.itss.exception.InternalErrorException;
import com.itss.exception.InvalidDataException;

public interface IService<T extends ITransferObject<ID>, ID extends Serializable> {
	
	/**
	 * Update.
	 * 
	 * @param entity the entity to be updated
	 * @throws InvalidDataException   the invalid data exception
	 * @throws InternalErrorException the internal error exception
	 * @throws DataNotFoundException  the data not found exception
	 */
	void update(T entity) throws InvalidDataException, InternalErrorException, DataNotFoundException;

	/**
	 * Creates the.
	 * 
	 * @param entity the entity to be created
	 * @return id of the entity created
	 * @throws InternalErrorException the internal error exception
	 * @throws InvalidDataException   the invalid data exception
	 */
	ID create(T entity) throws InternalErrorException, InvalidDataException;

	/**
	 * Read all.
	 * 
	 * @return the list of entities
	 * @throws InternalErrorException the internal error exception
	 */
	List<T> readAll() throws InternalErrorException;

	/**
	 * Find by id.
	 * 
	 * @param id the id of the entity to fetch
	 * @return the entity fetched
	 * @throws InternalErrorException the internal error exception
	 * @throws InvalidDataException   the invalid data exception
	 * @throws NoSuchMessageException the no such message exception
	 * @throws DataNotFoundException  the data not found exception
	 */
	T findById(ID id)
			throws InternalErrorException, InvalidDataException, DataNotFoundException;

	T createReturnTO(T transferObject) throws InternalErrorException, InvalidDataException, DataNotFoundException;

}
