package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.domain.User;
import ru.gb.repository.InterfaceUserRepository;
import java.util.List;

@Service
public class GetService {
    @Autowired
    private InterfaceUserRepository interfaceUserRepository;

    public List<User> getUsers() {
        return interfaceUserRepository.findAll();
    }
}
