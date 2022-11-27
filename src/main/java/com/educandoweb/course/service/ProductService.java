package com.educandoweb.course.service;

import com.educandoweb.course.domain.model.Order;
import com.educandoweb.course.domain.model.Product;
import com.educandoweb.course.exception.UserNotFoundException;
import com.educandoweb.course.repository.OrderRepository;
import com.educandoweb.course.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("Não existe cadastro de usuário com o id %d", id)
        ));
    }
}
