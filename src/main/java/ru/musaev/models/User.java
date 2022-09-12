package ru.musaev.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private boolean isAdmin;
}
