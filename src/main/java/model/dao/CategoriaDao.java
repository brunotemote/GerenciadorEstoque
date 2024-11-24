package model.dao; // pacote do DAO (Data Access Object)

import model.entities.Categoria; // importa a classe Categoria

import java.util.List; // importa a interface List

public interface CategoriaDao { // interface que define as operações de acesso a dados para a entidade Categoria

    void insert(Categoria obj); // insere uma nova categoria no banco de dados
    Integer update(String novoNome, String novaDescricao, String antigoNome); // atualiza uma categoria no banco de dados
    void deleteByName(String name); // exclui uma categoria do banco de dados pelo nome
    Categoria findByName(String name); // busca uma categoria no banco de dados pelo nome
    List<Categoria> findAll(); // busca todas as categorias do banco de dados
}
