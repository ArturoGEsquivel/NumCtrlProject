package com.itss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itss.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{	
	
	
}
