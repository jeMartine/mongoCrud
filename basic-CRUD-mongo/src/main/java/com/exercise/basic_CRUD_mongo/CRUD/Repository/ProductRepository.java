package com.exercise.basic_CRUD_mongo.CRUD.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exercise.basic_CRUD_mongo.CRUD.Entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
} 
