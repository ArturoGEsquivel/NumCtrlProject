

package com.itss.converter;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.itss.entity.IEntity;
import com.itss.exception.InternalErrorException;


/**
 * Definición de métodos para convertir de TO a Entidades y viceversa.
 * 
 * @author Diana Pérez
 */
@Component
public interface IConverter<E extends IEntity<?>, T extends Serializable> {

	/**
	 * Convierte un TO en una entidad.
	 * 
	 * @param transferObject objeto desde el que desea crear una entidad
	 * @return Entity obtenido a través de transferObject
	 * @throws InternalErrorException cuando la conversión no se puede realizar de una manera adecuada.
	 */
	E convert(T transferObject) throws InternalErrorException;

	/**
	 * Convierte un Entity a un Transfer Object.
	 * 
	 * @param entity desde el cual se desea crear un Transfer Object
	 * @return TransferObject obtenido a través del Entity
	 * @throws InternalErrorException cuando la conversión no se puede efectuar de
	 *                                una manera correcta
	 */
	T convert(E entity) throws InternalErrorException;

}
