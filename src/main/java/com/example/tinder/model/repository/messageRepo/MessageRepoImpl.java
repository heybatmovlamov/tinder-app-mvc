package com.example.tinder.model.repository.messageRepo;

import com.example.tinder.config.JdbcConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageRepoImpl implements MessageRepository {
    private final JdbcConfig jdbcConfig;

    @SneakyThrows
    @Override
    public String sendMessage(String message, long userId) {
        Connection connection = jdbcConfig.getConnection();

        String sql = "INSERT INTO messages (message, userId) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, message);
        preparedStatement.setLong(2, userId);
        preparedStatement.executeUpdate();
        return "Message inserted successfully!";
    }


    @SneakyThrows
    @Override
    public String getMessage(long userId){
        String sql = "SELECT message FROM messages WHERE userId = ?";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        String message = "";
        if (resultSet.next()) {
           message = resultSet.getString("message");
        }
        return message;
    }

}

