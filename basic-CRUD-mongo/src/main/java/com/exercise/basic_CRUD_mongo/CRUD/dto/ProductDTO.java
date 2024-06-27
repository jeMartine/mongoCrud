package com.exercise.basic_CRUD_mongo.CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//se hace la definición de la tabla de productos
public class ProductDTO {
    private String name;
    private int price; 
}
