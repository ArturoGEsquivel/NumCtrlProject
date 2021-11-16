/**
 * 
 */
package com.itss.service.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.itss.converter.IConverter;
import com.itss.dto.ITransferObject;
import com.itss.entity.IEntity;
import com.itss.exception.DataNotFoundException;
import com.itss.exception.InternalErrorException;
import com.itss.exception.InvalidDataException;
import com.itss.service.IService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractService<E extends IEntity<ID>, T extends ITransferObject<ID>, ID extends Serializable, R extends JpaRepository<E, ID>, C extends IConverter<E, T>>
		implements IService<T, ID> {

	@Autowired
	protected R repository;

	@Autowired
	protected C converter;

	@Override
	@Transactional
	public void update(T transferObject) throws InvalidDataException, InternalErrorException, DataNotFoundException {
		log.info("Updating  {} with id {}", transferObject.getClass().getName(), transferObject.getId());
		repository.save(converter.convert(transferObject));
	}

	@Override
	public ID create(T transferObject) throws InternalErrorException, InvalidDataException {
		log.info("Creating {} entry", transferObject.getClass().getName());
		E entity = converter.convert(transferObject);
		E e = repository.save(entity);
		return e.getId();
	}

	@Override
	public List<T> readAll() throws InternalErrorException {
		log.info("Find all");

		return repository.findAll().stream().map(e -> {
			try {
				return converter.convert(e);
			} catch (InternalErrorException ex) {
				log.error("Not possible to convert object {}", e.getClass().getName(), ex);
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	@Override
	public T findById(ID id)
			throws InternalErrorException, InvalidDataException, DataNotFoundException {
		E entity = repository.getOne(id);
		return converter.convert(entity);
	}
	
	@Override
	public T createReturnTO(T transferObject) throws InternalErrorException, InvalidDataException, DataNotFoundException {
		log.info("Creating {} entry", transferObject.getClass().getName());
		E entity = converter.convert(transferObject);
		E e = repository.save(entity);
		log.info("Save repository id = {}", e.getId());
		T to = converter.convert(e);
		log.info("Return TO {}", to.getClass().getName());
		return to;
	}

}
