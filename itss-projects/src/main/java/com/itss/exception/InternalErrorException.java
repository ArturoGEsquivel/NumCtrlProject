package com.itss.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>
 * Excepción personalizada.
 * <P>
 * Clase que se encarga de personalizar una excepción ocurrida por errores de logica del negocio.
 * 
 * @author Diana Perez
 * @version 1.0 Created on 10/11/2021 03:12:51 PM.
 * @since JDK 1.8
 */
@Slf4j
public class InternalErrorException extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 5546731600766965685L;

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalCause causa de la excepción.
	 */
	public InternalErrorException(final Throwable finalCause) {
		super(finalCause);
		log.error(finalCause.getMessage());
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage el mensaje que especifica la excepción.
	 */
	public InternalErrorException(final String finalMessage) {
		super(finalMessage);
		log.error(finalMessage);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage el mensaje que especifica la excepción.
	 * @param finalCause   causa de la excepción.
	 */
	public InternalErrorException(final String finalMessage, final Throwable finalCause) {
		super(finalMessage, finalCause);
		log.error(finalMessage + ": " + finalCause.getMessage(), finalCause);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage     el mensaje que especifica la excepción.
	 * @param finalCause       causa de la excepción.
	 * @param finalSuppression especificar si la advertencia debe suprimirse.
	 * @param finalStack       especifique si debe imprimirse la traza de la excepción.
	 */
	public InternalErrorException(final String finalMessage, final Throwable finalCause, final boolean finalSuppression,
			final boolean finalStack) {
		super(finalMessage, finalCause, finalSuppression, finalStack);
		log.error(finalMessage + ": " + finalCause.getMessage(), finalCause);
	}

}
