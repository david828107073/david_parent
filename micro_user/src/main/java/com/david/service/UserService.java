package com.david.service;

import com.david.repository.UserRepository;
import com.david.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void update(User user) { //DB必須有ID值
        userRepository.save(user);
    }


    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
