package com.educandoweb.course.service;

import com.educandoweb.course.domain.model.Category;
import com.educandoweb.course.domain.model.Order;
import com.educandoweb.course.exception.UserNotFoundException;
import com.educandoweb.course.repository.CategoryRepository;
import com.educandoweb.course.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("Não existe cadastro de usuário com o id %d", id)
        ));
    }
}
