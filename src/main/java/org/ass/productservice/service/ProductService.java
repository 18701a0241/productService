package org.ass.productservice.service;

import java.util.List;

import org.ass.productservice.entity.ProductEntity;


public interface ProductService {
	
	public ProductEntity saveProduct(ProductEntity productEntity);
	

	public ProductEntity findProductById(long id);
	
	public List<ProductEntity> findAllProduct();
	
	public ProductEntity deleteProductId(long id);
	
	public ProductEntity UpdateProductById(ProductEntity productEntity);
	
	public Integer findProductQuantityById(long id);
	
	public List<ProductEntity> findAllProductSortedByName();
	
	public List<ProductEntity> findProductByName(String name);
	
	public List<ProductEntity> getProductInRange(Double lowerPrice,Double higherPrice);
	
	public Double findProductPriceByProductById(long id);


}
