package ru.gb.services;

import org.springframework.stereotype.Service;
import ru.gb.domain.User;

@Service
public class NotificationService {

    public String notifyUser(User user){
        return "Пользователь " + user.getName() + " был создан";
    }
}
