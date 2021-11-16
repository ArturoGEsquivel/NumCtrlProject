package com.itss.converter;

import org.springframework.stereotype.Component;

import com.itss.dto.ProductTO;
import com.itss.entity.Product;
import com.itss.exception.InternalErrorException;

@Component("productConverter")
public class ProductConverter implements IConverter<Product, ProductTO>{

	@Override
	public Product convert(ProductTO transferObject) throws InternalErrorException {
		Product product = new Product();
		product.setId(transferObject.getId());
		product.setDescription(transferObject.getDescription());
		return product;
	}

	@Override
	public ProductTO convert(Product Product) throws InternalErrorException {
		ProductTO productTO = new ProductTO();
		productTO.setId(productTO.getId());
		productTO.setDescription(productTO.getDescription());
		return productTO;
	}



}
