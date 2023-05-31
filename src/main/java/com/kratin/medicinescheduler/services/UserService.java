package com.kratin.medicinescheduler.services;

import com.kratin.medicinescheduler.dao.UserRepository;
import com.kratin.medicinescheduler.dto.UserDto;
import com.kratin.medicinescheduler.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public User getUserByEmail(String email) {
        User user = null;
        user = this.userRepository.findByEmail(email);
        return user;
    }

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        this.userRepository.save(user);
    }

    public User checkUserExists(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}