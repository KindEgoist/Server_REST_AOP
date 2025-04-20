package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.domain.User;
import ru.gb.services.DataProcessingService;
import ru.gb.services.GetService;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private GetService getService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return dataProcessingService.sortUserByAge(getService.getUsers());
    }
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable("age") int age){
        return dataProcessingService.filterUserByAge(getService.getUsers(), age);
    }
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return dataProcessingService.calculateAverageAge(getService.getUsers());
    }
}
