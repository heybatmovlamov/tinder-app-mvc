package com.example.tinder.model.repository;

import com.example.tinder.config.JdbcConfig;
import com.example.tinder.model.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {

    private final JdbcConfig jdbcConfig; // Use constructor injection

    @SneakyThrows
    @Override
    public User login(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        PreparedStatement preparedStatement = jdbcConfig.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User(resultSet.getString("email"), resultSet.getString("password"));
        }
        return user;
    }
}
