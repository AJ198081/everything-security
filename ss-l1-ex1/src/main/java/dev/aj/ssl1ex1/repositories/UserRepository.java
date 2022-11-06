package dev.aj.ssl1ex1.repositories;

import dev.aj.ssl1ex1.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {

    Set<User> findByEmail(String email);

}
