package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void deleteById(Long id);
}
