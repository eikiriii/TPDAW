package com.upiiz.segundoparcial.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.upiiz.segundoparcial.Models.PublicacionesModel;
import com.upiiz.segundoparcial.Repositories.PublicacionesRepository;

@Service
public class PublicacionesService implements PublicacionesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PublicacionesModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM publicaciones",
                new BeanPropertyRowMapper<>(PublicacionesModel.class));
    }

     @Override
    public PublicacionesModel findById(int id) {
        return jdbcTemplate.query("SELECT * FROM publicaciones WHERE id=?",
                new BeanPropertyRowMapper<>(PublicacionesModel.class),id)
                .stream().findFirst().orElse(new PublicacionesModel());
    }

    @Override
    public List<PublicacionesModel> findEventosById(int idProduct) {
        return jdbcTemplate.query("SELECT * FROM publicaciones WHERE id = ?",
                        new BeanPropertyRowMapper<>(PublicacionesModel.class),idProduct);
    }

    @Override
    public void save(PublicacionesModel publicaciones) {
        jdbcTemplate.update("INSERT INTO publicaciones (titulo, contenido, id_categoria, fecha_publicacion) VALUES (?, ?, ?, ?)",
                publicaciones.getTitulo(), publicaciones.getContenido(), publicaciones.getId_categoria(), publicaciones.getFecha_publicacion());
    }

    @Override
    public void update(PublicacionesModel publicaciones) {
        jdbcTemplate.update("UPDATE publicaciones SET titulo=?, contenido=?, id_categoria=?, fecha_publicacion=? WHERE id=?",
                publicaciones.getTitulo(), publicaciones.getContenido(), publicaciones.getId_categoria(), publicaciones.getFecha_publicacion(), publicaciones.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM publicaciones WHERE id=?", id);
    }
    

}
