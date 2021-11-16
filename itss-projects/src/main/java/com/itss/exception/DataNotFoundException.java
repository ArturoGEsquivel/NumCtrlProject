package com.itss.exception;

/**
 * <P>
 * Excepción personalizada.
 * <P>
 * Clase que se encarga de personalizar una excepción ocurrida por error de dato no encontrado.
 * 
 * @author Diana Perez
 * @version 1.0 Created on 10/11/2021 03:12:51 PM.
 * @since JDK 1.8
 */
public class DataNotFoundException extends Exception {

	/** UID. */
	private static final long serialVersionUID = 5546731600766965685L;

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalCause causa de la excepción.
	 */
	public DataNotFoundException(final Throwable finalCause) {
		super(finalCause);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage el mensaje que especifica la excepción.
	 */
	public DataNotFoundException(final String finalMessage) {
		super(finalMessage);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage el mensaje que especifica la excepción.
	 * @param finalCause   causa de la excepción.
	 */
	public DataNotFoundException(final String finalMessage, final Throwable finalCause) {
		super(finalMessage, finalCause);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param finalMessage     el mensaje que especifica la excepción.
	 * @param finalCause       causa de la excepción.
	 * @param finalSuppression especificar si la advertencia debe suprimirse.
	 * @param finalStack       especifique si debe imprimirse la traza de la excepción.
	 */
	public DataNotFoundException(final String finalMessage, final Throwable finalCause, final boolean finalSuppression,
			final boolean finalStack) {
		super(finalMessage, finalCause, finalSuppression, finalStack);
	}

}
