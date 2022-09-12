package ru.musaev.repository;

import org.springframework.data.repository.CrudRepository;
import ru.musaev.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
