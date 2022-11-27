package com.educandoweb.course.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tb_category")
public class Category {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //private List<Product> products = new ArrayList<>();
}
