package com.openspection.auth.service;

import com.openspection.auth.model.User;
import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<User> findUsers(User probe);
    User encryptuser(User user);
}
