package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.ContactTO;
import com.itss.entity.Contact;
import com.itss.exception.InternalErrorException;

@Component("contactConverter")
public class ContactConverter implements IConverter<Contact, ContactTO>{

	@Override
	public Contact convert(ContactTO transferObject) throws InternalErrorException {
		Contact contact = new Contact();
		contact.setId(transferObject.getId());
		contact.setEmail(transferObject.getEmail());
		contact.setFirstNames(transferObject.getFirstNames());
		contact.setLastname(transferObject.getLastname());
		contact.setSurname(transferObject.getSurname());
		contact.setPhone(transferObject.getPhone());
		contact.setTypeContact(transferObject.getTypeContact());
		return contact;
	}

	@Override
	public ContactTO convert(Contact entity) throws InternalErrorException {
		ContactTO contactTO = new ContactTO();
		contactTO.setId(entity.getId());
		contactTO.setEmail(entity.getEmail());
		contactTO.setFirstNames(entity.getFirstNames());
		contactTO.setLastname(entity.getLastname());
		contactTO.setSurname(entity.getSurname());
		contactTO.setPhone(entity.getPhone());
		contactTO.setTypeContact(entity.getTypeContact());
		return contactTO;
	}



}
