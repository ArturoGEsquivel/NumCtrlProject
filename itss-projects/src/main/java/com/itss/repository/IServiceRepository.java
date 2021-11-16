package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Long>{	
	
	
}
