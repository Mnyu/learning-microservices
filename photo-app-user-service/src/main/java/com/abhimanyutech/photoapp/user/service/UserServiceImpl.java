package com.abhimanyutech.photoapp.user.service;

import com.abhimanyutech.photoapp.user.entity.UserEntity;
import com.abhimanyutech.photoapp.user.model.UserDTO;
import com.abhimanyutech.photoapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .userId(userDTO.getUserId())
                .build();
        userEntity.setEncryptedPassword("TEST");
        userRepository.save(userEntity);
        return null;
    }
}
