package com.example.tinder.model.repository.PeopleRepo;

import com.example.tinder.config.JdbcConfig;
import com.example.tinder.model.dto.ProfileDto;
import com.example.tinder.model.entity.ProfileEntity;
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
@Service
@RequiredArgsConstructor
public class ProfileRepoImpl implements ProfileRepository {
    private final JdbcConfig jdbcConfig;

    @SneakyThrows
    @Override
    public List<ProfileEntity> users() {
        List<ProfileEntity> entities = new ArrayList<>();
        Connection connection = jdbcConfig.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,username,photo,user_id FROM  profile ");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String username = resultSet.getString("username");
            String photo = resultSet.getString("photo");
            long userId = resultSet.getLong("user_id");
            ProfileEntity entity = new ProfileEntity(id, username, photo,userId);
            entities.add(entity);
        }
        return entities;
    }
    @SneakyThrows
    @Override
    public void likeOrDislike(boolean like, long userId, long likedUserId) {
        String sql = "INSERT INTO liked_profiles (userId, likedUserId) VALUES (?, ?)";
        PreparedStatement preparedStatement = jdbcConfig.getConnection().prepareStatement(sql);

        preparedStatement.setLong(1, userId);
        preparedStatement.setLong(2, likedUserId);
        preparedStatement.executeUpdate();

        if (like) {
            System.out.println("Profile liked and saved to database!");
        } else {
            System.out.println("Profile disliked, not saving to database.");
        }
    }

}
