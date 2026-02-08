package com.gabriel.usersapi.service;

import com.gabriel.usersapi.dto.UserCreateDTO;
import com.gabriel.usersapi.dto.UserResponseDTO;
import com.gabriel.usersapi.model.User;
import org.springframework.stereotype.Service;
import com.gabriel.usersapi.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository; //usando repository dentro do service

    public UserService(UserRepository repository) {
        this.repository = repository;
    }//injeção via construtor


    public UserResponseDTO create(UserCreateDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User saved = repository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }
}
