package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String>{	
	
	
}
