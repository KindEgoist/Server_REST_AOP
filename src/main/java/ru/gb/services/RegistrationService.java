package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.domain.User;
import ru.gb.repository.InterfaceUserRepository;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    InterfaceUserRepository interfaceUserRepository;

    public User processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        return interfaceUserRepository.save(user);
    }
}
