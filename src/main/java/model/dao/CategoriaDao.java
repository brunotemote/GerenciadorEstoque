package model.dao;

import model.entities.Categoria;

import java.util.List;

public interface CategoriaDao {

    void insert(Categoria obj);
    Integer update(String novoNome, String novaDescricao, String antigoNome);
    void deleteByName(String name);
    Categoria findByName(String name);
    List<Categoria> findAll();

}
