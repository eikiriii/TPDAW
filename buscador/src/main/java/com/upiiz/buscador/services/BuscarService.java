package com.upiiz.buscador.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upiiz.buscador.models.BuscarModel;

@Service
public class BuscarService {
    
    @Autowired
    private DataSource dataSource;

    public List<BuscarModel> buscarPorNombre(String query) {
        List<BuscarModel> resultados = new ArrayList<>();

        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT id, nombre FROM busca WHERE nombre LIKE ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "%" + query + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        resultados.add(new BuscarModel(rs.getInt("id"), rs.getString("nombre")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return resultados;
    }

}
