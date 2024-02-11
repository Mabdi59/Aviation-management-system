package com.mohamedabdi.aviationmanagement.services;

import com.mohamedabdi.aviationmanagement.dao.UserDao;
import com.mohamedabdi.aviationmanagement.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userDao.save(user);
    }

    public Optional<User> login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userDao.findById(id));
    }

    public boolean updateUser(User updatedUser) {
        User existingUser = userDao.findById(updatedUser.getUserId());
        if (existingUser != null) {
            // Check if password needs re-hashing
            if (!passwordEncoder.matches(updatedUser.getPassword(), existingUser.getPassword())) {
                updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            userDao.save(updatedUser);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        if (userDao.findById(id) != null) {
            userDao.deleteById(id);
            return true;
        }
        return false;
    }
}
