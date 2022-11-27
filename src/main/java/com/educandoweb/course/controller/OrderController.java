package com.educandoweb.course.controller;

import com.educandoweb.course.domain.model.Order;
import com.educandoweb.course.domain.model.User;
import com.educandoweb.course.repository.OrderRepository;
import com.educandoweb.course.service.OrderService;
import com.educandoweb.course.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok( orderService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            var response = orderService.findById(id);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
