package com.educandoweb.course.service;

import com.educandoweb.course.domain.model.User;
import com.educandoweb.course.exception.UserNotFoundException;
import com.educandoweb.course.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public User create(User user){
        return userRepository.save(user);
    }
    public void delete(Long id){
        var user = findById(id);
        userRepository.delete(user);
    }

    public User update(Long id, User user){
        var userAtDataBase = findById(id);
        BeanUtils.copyProperties(user, userAtDataBase, "id");
//        User entity = userRepository.getReferenceById(id); Melhor que o find by id , n lembro pq
//        entity.setName(user.getName());
//        entity.setEmail(user.getEmail());
//        entity.setPhone(user.getPhone());
        return create(userAtDataBase);
    }
}
