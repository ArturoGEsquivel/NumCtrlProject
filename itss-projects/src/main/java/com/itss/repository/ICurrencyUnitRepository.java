package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.CurrencyUnit;

@Repository
public interface ICurrencyUnitRepository extends JpaRepository<CurrencyUnit, Long>{	
	
	
}
