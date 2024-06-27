package com.exercise.basic_CRUD_mongo.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.basic_CRUD_mongo.CRUD.Entity.Product;
import com.exercise.basic_CRUD_mongo.CRUD.Service.ProductService;
import com.exercise.basic_CRUD_mongo.CRUD.dto.ProductDTO;
import com.exercise.basic_CRUD_mongo.global.exceptions.AttributeException;
import com.exercise.basic_CRUD_mongo.global.exceptions.ResourceNotFoundException;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable ("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(productService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<Product> save (@RequestBody ProductDTO dto) throws AttributeException{
        return ResponseEntity.ok(productService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable ("id") int id, @RequestBody ProductDTO dto) throws ResourceNotFoundException, AttributeException{
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable ("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(productService.detele(id));
    }
}
