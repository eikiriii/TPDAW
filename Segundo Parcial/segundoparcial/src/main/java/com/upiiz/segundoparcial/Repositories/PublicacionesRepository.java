package com.upiiz.segundoparcial.Repositories;

import java.util.List;

import com.upiiz.segundoparcial.Models.PublicacionesModel;

public interface PublicacionesRepository {
    List<PublicacionesModel> findAll();
    PublicacionesModel findById(int id);
    List<PublicacionesModel> findEventosById(int idProduct);
    void save(PublicacionesModel Eventos);
    void update(PublicacionesModel Eventos);
    void deleteById(int id);
}
