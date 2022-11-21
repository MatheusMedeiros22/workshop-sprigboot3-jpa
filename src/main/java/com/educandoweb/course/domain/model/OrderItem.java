package com.educandoweb.course.domain.model;

import lombok.Data;

@Data
public class OrderItem {

    private Integer quantity;
    private Double price;

    public Double subTotal(){
        return quantity * price;
    }
}
