package com.example.tinder.model.repository.listRepo;

import com.example.tinder.config.JdbcConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class PeopleListRepoImpl implements PeopleListRepository{
    private final JdbcConfig jdbcConfig;
    @SneakyThrows
    @Override
    public List<Integer> chooseLikedUser(long userId) {
        Connection connection = jdbcConfig.getConnection();
        List<Integer> list = new ArrayList<>();
        String likedUserSql = "SELECT likeduserid FROM liked_profiles WHERE userId = ?";
        PreparedStatement likedPreparedStatement = connection.prepareStatement(likedUserSql);
        likedPreparedStatement.setLong(1, userId);
        ResultSet resultSet = likedPreparedStatement.executeQuery();
        while (resultSet.next()) {
            int likedUserId = resultSet.getInt("likeduserid");
            list.add(likedUserId);
        }
        return list;
    }
}
