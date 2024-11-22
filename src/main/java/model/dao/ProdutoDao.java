package model.dao;

import model.entities.Categoria;
import model.entities.Produto;

import java.util.List;

public interface ProdutoDao {

    boolean insert(Produto obj);
    Integer update(String nome, String valorCompra, String valorVenda, String quantidade);
    void deleteByName(String name);
    Produto findByName(String name);
    List<Produto> findAll();
    List<Produto> findByCategoria(Categoria categoria);
}
