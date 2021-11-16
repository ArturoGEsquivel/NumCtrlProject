package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long>{	
	
	
}
