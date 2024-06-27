package com.exercise.basic_CRUD_mongo.CRUD.Service;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.basic_CRUD_mongo.CRUD.Entity.Product;
import com.exercise.basic_CRUD_mongo.CRUD.Repository.ProductRepository;
import com.exercise.basic_CRUD_mongo.CRUD.dto.ProductDTO;
import com.exercise.basic_CRUD_mongo.global.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    //private methods
    private int autoIncrementID(){
        List<Product> products = productRepository.findAll();
        return products.isEmpty() ? 1 : 
            products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;

    }

    //retornar todos los productos
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    //retornar un producto
    public Product getOne(int id) throws ResourceNotFoundException{
        return productRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Product not found"));
    }

    //guardar un producto
    public Product save(ProductDTO productDTO){
        int id = autoIncrementID();
        Product product = new Product(id, productDTO.getName(), productDTO.getPrice());
        return productRepository.save(product);
    }

    //actualizar un producto
    public Product update(int id, ProductDTO productDTO) throws ResourceNotFoundException{
        Product product = productRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    //Eliminar un producto
    public Product detele(int id) throws ResourceNotFoundException{
        Product product = productRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
        return product;
    }
    

}
