package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.JobTitle;

@Repository
public interface IJobTitleRepository extends JpaRepository<JobTitle, Long>{	
	
	
}
