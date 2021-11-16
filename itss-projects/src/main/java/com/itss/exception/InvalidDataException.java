package com.itss.exception;


import java.util.LinkedList;
import java.util.List;

import com.itss.dto.ErrorTO;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>
 * Excepción personalizada para datos no válidos.
 * <P>
 * 
 * @author Diana Perez
 * @since JDK 1.8
 */

@Slf4j
public class InvalidDataException extends Exception {

	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = -3500580442549145232L;

	/** Objeto error TO. */
	private final List<ErrorTO> errorTO;

	/**
	 * Crea una instancia de una nueva excepción de datos no válidos.
	 * 
	 * @param error the error
	 */
	public InvalidDataException(final List<ErrorTO> error) {
		super();
		this.errorTO = error;
		log.error("InvalidDataException:" + errorTO);
	}

	/**
	 * Crea una instancia de una nueva excepción de datos no válidos.
	 * 
	 * @param error contiene el error
	 */
	public InvalidDataException(ErrorTO error) {
		super();
		this.errorTO = new LinkedList<>();
		this.errorTO.add(error);
		log.error("InvalidDataException:" + errorTO);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param error      contiene el error
	 * @param finalCause causa de la excepción.
	 */
	public InvalidDataException(List<ErrorTO> error, final Throwable finalCause) {
		super(finalCause);
		this.errorTO = error;
		log.error(finalCause.getMessage());
	}

	/**
	 * Throws the custom exception.
	 * 
	 * @param error        contiene el error
	 * @param finalMessage el mensaje que especifica la excepción.
	 */
	public InvalidDataException(final List<ErrorTO> error, final String finalMessage) {
		super(finalMessage);
		this.errorTO = error;
		log.error(finalMessage);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param error        contiene el error
	 * @param finalMessage el mensaje que especifica la excepción.
	 * @param finalCause   causa de la excepción.
	 */
	public InvalidDataException(final List<ErrorTO> error, final String finalMessage, final Throwable finalCause) {
		super(finalMessage, finalCause);
		this.errorTO = error;
		log.error(finalMessage + ": " + finalCause.getMessage(), finalCause);
	}

	/**
	 * Lanza la excepción personalizada.
	 * 
	 * @param error            contiene el error
	 * @param finalMessage     el mensaje que especifica la excepción.
	 * @param finalCause       causa de la excepción.
	 * @param finalSuppression especificar si la advertencia debe suprimirse.
	 * @param finalStack       especifique si debe imprimirse la traza de la excepción.
	 */
	public InvalidDataException(final List<ErrorTO> error, final String finalMessage, final Throwable finalCause,
			final boolean finalSuppression, final boolean finalStack) {
		super(finalMessage, finalCause, finalSuppression, finalStack);
		this.errorTO = error;
		log.error(finalMessage + ": " + finalCause.getMessage(), finalCause);
	}

	/**
	 * Obtiene el error TO.
	 * 
	 * @return el error TO
	 */
	public List<ErrorTO> getErrorTO() {
		return errorTO;
	}

}
