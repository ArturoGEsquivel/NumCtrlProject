package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Profile;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, String>{	
	
	
}
