package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Security;

@Repository
public interface ISecurityRepository extends JpaRepository<Security, Long>{	
	
	
}
