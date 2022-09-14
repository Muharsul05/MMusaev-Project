package ru.musaev.service;

import ru.musaev.dataObjects.User;
import ru.musaev.dataObjects.UserInfo;

public interface TokenService {
    String generateToken(User user);

    UserInfo parseToken(String token);
}
