package service;

import dto.UserCreateDTO;
import dto.UserResponseDTO;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
}
