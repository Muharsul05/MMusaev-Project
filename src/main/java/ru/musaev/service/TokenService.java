package ru.musaev.service;

import ru.musaev.models.User;
import ru.musaev.models.UserInfo;

public interface TokenService {
    String generateToken(User user);
    UserInfo parseToken(String token);
}
