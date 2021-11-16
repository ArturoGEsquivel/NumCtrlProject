package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long>{	
	
	
}
