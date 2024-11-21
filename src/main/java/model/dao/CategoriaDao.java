package model.dao;

import model.entities.Categoria;

import java.util.List;

public interface CategoriaDao {

    void insert(Categoria obj);
    void update(Categoria obj);
    void deleteByName(String name);
    Categoria findByName(String name);
    List<Categoria> findAll();

}
