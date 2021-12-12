package com.Luis.kenway.RETOC42.repository;

import com.Luis.kenway.RETOC42.model.Products;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCrudRepository extends MongoRepository<Products, String> {
}
