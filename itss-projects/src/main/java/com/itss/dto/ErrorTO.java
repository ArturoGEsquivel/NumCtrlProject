package com.itss.dto;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <P>
 * DTO object to represent the error data from a request.
 * <P>
 * 
 * @author Diana Pérez
 * @since JDK 1.8 Modifications:
 */
@Data
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorTO implements Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -6242630175803102635L;

	/** The property name that failed the validation. */
	private String property;

	/** The interpolated message from the failed validation. */
	private String interpolatedMessage;

	/** The validation type that was executed over the property. */
	private String validationType;

	/** The value use to executed the validation. */
	private Object value;

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String objectString = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			objectString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			log.warn("Unable to parse ErrorTO object");
		}
		return objectString;
	}

}
