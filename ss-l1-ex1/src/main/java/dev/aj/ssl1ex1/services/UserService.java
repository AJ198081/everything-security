package dev.aj.ssl1ex1.services;

import dev.aj.ssl1ex1.domain.model.User;
import dev.aj.ssl1ex1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;

    @PostConstruct
    void loadDatabaseWithUsers() {
        User user1 = User.builder()
                .userName("aj81")
                .firstName("AJ")
                .lastName("Bhandal")
                .email("amarjitbhandal@gmail.com")
                .password("password")
                .build();

        Set<User> usersByEmail = repository.findByEmail(user1.getEmail());
        boolean empty = usersByEmail.stream().map(User::getEmail).filter(email -> email.equals(user1.getEmail())).findFirst().isEmpty();

        if(empty) {
           repository.save(user1);
           log.info("DB is loaded with a User to get you started.");
       } else {
            log.info("DB already has at least one User, and you are good to go!");
        }

    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
