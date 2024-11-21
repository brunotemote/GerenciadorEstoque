package model.dao;

import model.entities.Categoria;
import model.entities.Produto;

import java.util.List;

public interface ProdutoDao {

    void insert(Produto obj);
    void update(Produto obj);
    void deleteByName(String name);
    Produto findByName(String name);
    List<Produto> findAll();
    List<Produto> findByCategoria(Categoria categoria);
}
