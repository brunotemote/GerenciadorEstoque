package model.dao;

import model.entities.Categoria;
import model.entities.Produto;

import java.util.List;

public interface ProdutoDao {

    boolean insert(Produto obj);
    Integer update(String nome, String valorCompra, String valorVenda, String quantidade);
    Integer deleteByName(String name);
    Produto findByName(String name);
    Produto findByNameAndCategory(String name, Categoria categoria);
    List<Produto> findAll();
    List<Produto> findAllByCategoria(Categoria categoria);

}
