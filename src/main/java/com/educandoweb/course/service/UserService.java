package com.educandoweb.course.service;

import com.educandoweb.course.domain.model.User;
import com.educandoweb.course.exception.UserNotFoundException;
import com.educandoweb.course.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("Não existe cadastro de usuário com o id %d", id)
        ));
    }
}
