package ru.netology.spring_boot_rest_task1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest_task1.model.Authorities;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return null;
    }
}
