package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    boolean existsByEmail(String email);//saber se o usuario existe

    Optional<User> findByEmail(String email);//buscar o usuario
}
