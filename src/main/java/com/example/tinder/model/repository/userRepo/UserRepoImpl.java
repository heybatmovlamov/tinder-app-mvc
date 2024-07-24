package com.example.tinder.model.repository.userRepo;

import com.example.tinder.config.JdbcConfig;
import com.example.tinder.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {

    private final JdbcConfig jdbcConfig; // Use constructor injection

    @SneakyThrows
    @Override
    public Optional<UserEntity> login(String email, String password) {
        UserEntity userEntity = null;

        String selectQuery = "SELECT * FROM users WHERE   email = ? AND password = ?";
        PreparedStatement selectStatement = jdbcConfig.getConnection().prepareStatement(selectQuery);
        selectStatement.setString(1, email);
        selectStatement.setString(2, password);

        ResultSet resultSet = selectStatement.executeQuery();

        // Update the login_time for the logged in user (assuming 'login_time' is a column in 'users' table)
        String updateQuery = "UPDATE users SET login_time = ? WHERE email = ?";
        PreparedStatement updateStatement = jdbcConfig.getConnection().prepareStatement(updateQuery);
        updateStatement.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        updateStatement.setString(2, email);
        updateStatement.executeUpdate();



        if (resultSet.next()) {
            userEntity = new UserEntity(
                    resultSet.getLong("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getLong("person_id")
            );

            updateStatement.close();
        }

        selectStatement.close();
        return Optional.ofNullable(userEntity);
    }
}
