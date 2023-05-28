package org.ass.productservice.service.impl;

import java.util.List;

import org.ass.productservice.entity.ProductEntity;
import org.ass.productservice.repository.impl.ProductRepositoryimpl;
import org.ass.productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepositoryimpl productRepository;
	
	@Override
	public ProductEntity findProductById(long id) {
		
		return productRepository.findProductById(id);
	}
	@Override
	public List<ProductEntity> findAllProduct() {
		
		return productRepository.findAllProduct() ;
	}
	@Override
	public ProductEntity deleteProductId(long id) {
		
		return productRepository.deleteProductId(id);
	}
	
	
	@Override
	public ProductEntity UpdateProductById(ProductEntity productEntity) {
		
		return productRepository.UpdateProductById(productEntity);
	}
	
	
	@Override
	public Integer findProductQuantityById(long id) {
		
		return productRepository.findProductQuantityById(id);
	}
	@Override
	public List<ProductEntity> findAllProductSortedByName() {
		
		return productRepository.findAllProductSortedByName();
	}
	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		
		return productRepository.saveProduct(productEntity);
	}
	@Override
	public List<ProductEntity> findProductByName(String name) {
		
		return productRepository.findProductByName(name);
	}
	@Override
	public List<ProductEntity> getProductInRange(Double lowerPrice, Double higherPrice) {
		
		return productRepository.getProductInRange(lowerPrice,higherPrice);
	}
	public Double findProductPriceByProductById(long id) {
		
		return productRepository.findProductPriceByProductById(id);
	}
	
	
	}
	
	
		
	
