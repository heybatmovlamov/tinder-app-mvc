package com.example.tinder.model.repository.PeopleRepo;

import com.example.tinder.config.JdbcConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@RequiredArgsConstructor
public class PeopleRepoImpl implements PeopleRepository{
    private final JdbcConfig jdbcConfig;
    @SneakyThrows
    @Override
    public String users(boolean likeOrDislike) {
        Connection connection = jdbcConfig.getConnection();
        connection.prepareStatement("");
        return null;
    }
}
