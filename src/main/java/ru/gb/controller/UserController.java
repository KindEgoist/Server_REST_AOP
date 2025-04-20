package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.User;
import ru.gb.services.GetService;
import ru.gb.services.RegistrationService;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    private GetService getService;

    @GetMapping
    public List<User> users(){
        return getService.getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "Пользователь добавлен в базу";
    }

    @PostMapping("/param")
    public void userAddFromParam(@RequestParam String name,
                                 @RequestParam(required = false, defaultValue = "0") int age,
                                 @RequestParam String email) {
        registrationService.processRegistration(name, age, email);
    }

}
