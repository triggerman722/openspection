package com.openspection.auth.service;

import com.openspection.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
