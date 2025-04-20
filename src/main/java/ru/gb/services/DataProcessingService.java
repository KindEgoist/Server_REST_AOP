package ru.gb.services;

import org.springframework.stereotype.Service;
import ru.gb.aspect.TrackUserAction;
import ru.gb.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @TrackUserAction("Сортировка по годам")
    public List<User> sortUserByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(user -> user.getAge())).collect(Collectors.toList());
    }

    @TrackUserAction("Фильтр по годам")
    public List<User> filterUserByAge(List<User> users, int age){
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }

    @TrackUserAction("Средняя по годам")
    public double calculateAverageAge(List<User> users){
        return users.stream().mapToInt(user -> user.getAge()).average().orElse(0);
    }

}
