package ru.musaev.dataObjects;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfo {
    private Integer id;
    private String username;
    private boolean isAdmin;

    public UserInfo(Integer id, String username, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.isAdmin = isAdmin;
    }
}
