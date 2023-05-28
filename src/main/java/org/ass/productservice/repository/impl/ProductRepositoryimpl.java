package org.ass.productservice.repository.impl;

import java.util.List;

import org.ass.productservice.entity.ProductEntity;
import org.ass.productservice.repository1.ProductRepository;
import org.ass.productservice.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryimpl implements ProductRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
public ProductEntity  saveProduct(ProductEntity productEntity) {
	
	
	try {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(productEntity);
		transaction.commit();
		return productEntity;
		
		} catch (Exception e) {
			
		}	
	return null;
	
}
	
	public ProductEntity findProductById(long id) {
	 try {
		Session session = sessionFactory.openSession();
		
		return session.get(ProductEntity.class,id); 
	 }catch(Exception e) {
		 
	 }
	return null;
		
	}
	
	public List<ProductEntity> findAllProduct(){
		StringBuilder builder = new StringBuilder();
		builder.append("from ProductEntity");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(builder.toString());
		return query.getResultList();
		
		
	}
	
	public ProductEntity deleteProductId(long id) {
		ProductEntity productById = findProductById(id);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(productById);
		transaction.commit();
		return productById;	
		
	}
	
	public ProductEntity UpdateProductById(ProductEntity productEntity) {
		ProductEntity ProductById = findProductById(productEntity.getAltkey());
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object object = session.merge(productEntity);
		transaction.commit();
		return (ProductEntity)object;
		
		
	}
	
	public Integer findProductQuantityById(long id) {
		ProductEntity productById = findProductById(id);
		Session session = sessionFactory.openSession();
		return productById.getQuantity();
		
	}
	
	public List<ProductEntity> findAllProductSortedByName(){
		StringBuilder builder = new StringBuilder();
		builder.append("from ProductEntity order by name desc");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(builder.toString());
		return query.getResultList();

//		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Query query = session.createQuery(builder.toString());
//		 List<ProductEntity> list = query.getResultList();
//		 List<ProductEntity> list2 = list.stream().sorted((e1,e2)->e1.getName().compareToIgnoreCase(e2.getName())).
//		 collect(Collectors.toList());
//		return list2;
		
		
	}
	
	public List<ProductEntity> findProductByName(String name) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("from ProductEntity where name=:n");
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(builder.toString());
		query.setParameter("n",name);
		return query.getResultList();
	}
	
	public List<ProductEntity> getProductInRange(Double lowerPrice,Double higherPrice) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("from ProductEntity where price>=:l and price<=:h");
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(builder.toString());
		query.setParameter("l",lowerPrice);
		query.setParameter("h",higherPrice);
		return query.getResultList();
	}
	public Double findProductPriceByProductById(long id) {

		Session session = sessionFactory.openSession();
		ProductEntity productEntity = session.get(ProductEntity.class,id);

		return productEntity.getPrice();
		
	}

	

}
