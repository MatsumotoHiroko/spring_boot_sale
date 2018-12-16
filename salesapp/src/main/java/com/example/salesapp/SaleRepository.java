package com.example.salesapp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sale", path = "sale")
public interface SaleRepository extends MongoRepository<Sale, String> {

	List<Sale> findByTitle(@Param("name") String name);
	List<Sale> findByCountry(@Param("name") String name);
	List<Sale> findByState(@Param("name") String name);
	List<Sale> findByCity(@Param("name") String name);
	
	List<Sale> findByDescriptionLike(@Param("name") String name);
	List<Sale> findByStreetLike(@Param("name") String name);
	
	List<Sale> findAllByOrderByPriceAsc();
	List<Sale> findAllByOrderByPriceDesc();
	List<Sale> findAllByOrderByStockAsc();
	List<Sale> findAllByOrderByStockDesc();
	
	List<Sale> findByPriceBetween(@Param("grater") int grater, @Param("less") int less);
	List<Sale> findByStockBetween(@Param("grater") int grater, @Param("less") int less);
}