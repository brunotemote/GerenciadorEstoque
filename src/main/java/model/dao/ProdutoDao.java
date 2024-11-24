package model.dao; // pacote do DAO (Data Access Object)

import model.entities.Categoria; // importa a classe Categoria
import model.entities.Produto; // importa a classe Produto

import java.util.List; // importa a interface List

public interface ProdutoDao { // interface que define as operações de acesso a dados para a entidade Produto

    boolean insert(Produto obj); // insere um novo produto no banco de dados
    Integer update(String nome, String valorCompra, String valorVenda, String quantidade); // atualiza um produto no banco de dados
    Integer deleteByName(String name); // exclui um produto do banco de dados pelo nome
    Produto findByName(String name); // busca um produto no banco de dados pelo nome
    Produto findByNameAndCategory(String name, Categoria categoria); // busca um produto pelo nome e categoria
    List<Produto> findAll(); // busca todos os produtos do banco de dados
    List<Produto> findAllByCategoria(Categoria categoria); // busca todos os produtos de uma categoria
}
