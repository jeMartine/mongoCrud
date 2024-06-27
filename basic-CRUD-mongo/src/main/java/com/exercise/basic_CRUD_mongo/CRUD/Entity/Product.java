package com.exercise.basic_CRUD_mongo.CRUD.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//usar lombok para no usar constructores
@Data
@AllArgsConstructor
@NoArgsConstructor
//se hace la definición de la tabla de productos
@Document(collection = "productos")
public class Product {
    @Id
    private int id;
    private String name;
    private int price; 
}
