package ru.gb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.domain.User;


@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Integer> {
}
