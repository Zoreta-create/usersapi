package com.gabriel.usersapi.controller;

import com.gabriel.usersapi.dto.UserCreateDTO;
import com.gabriel.usersapi.dto.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.gabriel.usersapi.service.UserService;

import java.util.List;

@RestController
    @RequestMapping("/users")
    @RequiredArgsConstructor
    @CrossOrigin
public class UserController {
    private final UserService service;

    //POST - CRIAR USUARIO
    @PostMapping
    public UserResponseDTO create (
            @Valid @RequestBody UserCreateDTO dto) {
        return service.create(dto);
    }

    //GET - LISTAR USUARIOS
        @GetMapping
        public List<UserResponseDTO>findAll() {
            return service.findAll();
        }
}
