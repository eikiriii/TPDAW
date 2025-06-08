package com.upiiz.likes_ajax.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.likes_ajax.Models.Likes;

@Service
public class LikeService {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Likes obtenerLikes() {
        String query = "SELECT * FROM imagen_likes WHERE ID = 1";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return new Likes(
                    rs.getInt("Imagen1"),
                    rs.getInt("Imagen2"),
                    rs.getInt("Imagen3")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Likes(0, 0, 0);
    }

    public void aumentarLike(int imagen) {
        String column = switch (imagen) {
            case 1 -> "Imagen1";
            case 2 -> "Imagen2";
            case 3 -> "Imagen3";
            default -> null;
        };

        if (column == null) return;

        String update = "UPDATE imagen_likes SET " + column + " = " + column + " + 1 WHERE ID = 1";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
