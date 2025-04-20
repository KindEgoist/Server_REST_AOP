package ru.gb.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
    private String name;

    @Column(nullable = false)
    @Min(value = 0, message = "Возраст должен быть не меньше 0")
    @Max(value = 120, message = "Возраст должен быть не больше 120")
    private int age;

    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "Адресс почты должен быть от 5 до 50 символов")
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId (int id){
        this.id = id;
    }

}
