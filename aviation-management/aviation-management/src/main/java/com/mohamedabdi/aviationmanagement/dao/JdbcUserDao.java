package com.mohamedabdi.aviationmanagement.dao;

import com.mohamedabdi.aviationmanagement.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setEmailVerified(rs.getBoolean("is_email_verified"));
        user.setAccountNonLocked(rs.getBoolean("is_account_non_locked"));
        user.setEnabled(rs.getBoolean("is_enabled"));
        user.setRole(rs.getString("role"));
        return user;
    };
    private final ResultSetExtractor<User> singleUserExtractor =
            (rs) -> rs.next() ? userRowMapper.mapRow(rs, 1) : null;

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (username, password, email, is_email_verified, is_account_non_locked, is_enabled, role) VALUES (?, ?, ?, ?, ?, ?, ?) ON CONFLICT (username) DO UPDATE SET password = EXCLUDED.password, email = EXCLUDED.email, is_email_verified = EXCLUDED.is_email_verified, is_account_non_locked = EXCLUDED.is_account_non_locked, is_enabled = EXCLUDED.is_enabled, role = EXCLUDED.role";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getEmailVerified(), user.getAccountNonLocked(), user.getEnabled(), user.getRole());
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, userRowMapper);
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, userRowMapper);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
