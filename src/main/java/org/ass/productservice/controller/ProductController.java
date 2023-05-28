package org.ass.productservice.controller;

import java.util.List;

import org.ass.productservice.entity.ProductEntity;
import org.ass.productservice.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value="/saveProduct")
	public @ResponseBody ProductEntity saveProduct(@RequestBody ProductEntity productEntity) {
		
		return productServiceImpl.saveProduct(productEntity);	
	}
	
	@RequestMapping(value="/findProductById/{altkey}")
	public @ResponseBody ProductEntity findProductById(@PathVariable("altkey") long id) {
		return productServiceImpl.findProductById(id);	
	}
	
	@RequestMapping(value="/findAllProduct")
	public @ResponseBody List<ProductEntity> findAllProduct() {
		return productServiceImpl.findAllProduct();	
	}
	
	@RequestMapping(value="/deleteProductId")
	public @ResponseBody ProductEntity deleteProductId(@RequestBody long id) {
		return productServiceImpl.findProductById(id);	
	}
	
	@RequestMapping(value="/findProductQuantityById/{altkey}")
	public @ResponseBody Integer findProductQuantityById(@PathVariable("altkey") long id) {
		return productServiceImpl.findProductQuantityById(id);	
	}
	
	@RequestMapping(value="/findAllProductSortedByName")
	public @ResponseBody List<ProductEntity> findAllProductSortedByName() {
		return productServiceImpl.findAllProductSortedByName();
	
	}
	
	@PutMapping(value="/UpdateProductById")
	public @ResponseBody ProductEntity UpdateProductById(@RequestBody ProductEntity productEntity) {
		
		return productServiceImpl.UpdateProductById(productEntity);	
	}
	
	@RequestMapping(value="/findProductByName/{name}")
	public List<ProductEntity> findProductByName(@PathVariable("name") String name){
		return productServiceImpl.findProductByName(name);
		
	}
	
	@RequestMapping(value="/getProductInRange")
	public List<ProductEntity> getProductInRange(@RequestParam("lowerPrice") Double lowerPrice,@RequestParam("higherPrice") Double higherPrice){
		return productServiceImpl.getProductInRange(lowerPrice, higherPrice);
		
	}
	
	@GetMapping(value="/findProductPriceByProductById/{id}")
	public Double findProductPriceByProductId(@PathVariable("id") long id){
		return productServiceImpl.findProductPriceByProductById(id);
		
	}
}
