package com.example.tinder.model.repository.userRepo;

import com.example.tinder.config.JdbcConfig;
import com.example.tinder.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {

    private final JdbcConfig jdbcConfig; // Use constructor injection

    @SneakyThrows
    @Override
    public Optional<UserEntity> login(String email, String password) {
        UserEntity userEntity = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        PreparedStatement preparedStatement = jdbcConfig.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            userEntity = new UserEntity(resultSet.getString("email"), resultSet.getString("password"));
        }
        return Optional.ofNullable(userEntity);
    }
}
