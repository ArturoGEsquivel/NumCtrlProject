package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Status;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long>{	
	
	
}
