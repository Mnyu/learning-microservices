package com.abhimanyutech.photoapp.user.service;

import com.abhimanyutech.photoapp.user.entity.UserEntity;
import com.abhimanyutech.photoapp.user.model.UserDTO;
import com.abhimanyutech.photoapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());
        userDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        UserEntity userEntity = UserEntity.builder()
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .userId(userDTO.getUserId())
                .encryptedPassword(userDTO.getEncryptedPassword())
                .build();
        userRepository.save(userEntity);
        return userDTO;
    }
}
