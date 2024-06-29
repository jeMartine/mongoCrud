package com.exercise.basic_CRUD_mongo.CRUD.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Product name is mandatory")
    private String name;

    @NotNull()
    @Min(value = 1, message = "Product price must be at least 1")
    private int price;
}