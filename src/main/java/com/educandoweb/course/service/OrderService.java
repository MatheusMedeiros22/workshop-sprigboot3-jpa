package com.educandoweb.course.service;

import com.educandoweb.course.domain.model.Order;
import com.educandoweb.course.exception.UserNotFoundException;
import com.educandoweb.course.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("Não existe cadastro de usuário com o id %d", id)
        ));
    }
}
