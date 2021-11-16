
package com.itss.entity;

import java.io.Serializable;

/**
 * Definición de clase para ser usado con entities.
 * @author Diana Perez
 */
public interface IEntity<ID extends Serializable> extends Serializable {
	
	/**
	 * Método que devuelve el id de la entidad
	 * @return ID
	 */
	ID getId();

}
