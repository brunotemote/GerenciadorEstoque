package model.entities; // pacote da entidade

import java.io.Serializable; // importa a interface Serializable
import java.util.Objects; // importa a classe Objects

public class Categoria implements Serializable { // classe que representa uma categoria, implementa Serializable para permitir a serialização do objeto

    private static final long serialVersionUID = 1L; // número de versão da classe para serialização

    private Integer id; // identificador único da categoria
    private String nome; // nome da categoria
    private String descricao; // descrição da categoria

    public Categoria() { // construtor padrão
    }

    public Categoria(String descricao, Integer id, String nome) { // construtor com parâmetros
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
    }

    // getters e setters para os atributos da classe
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) { // sobrescreve o método equals para comparar categorias pelo nome
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() { // sobrescreve o método hashCode para gerar um código hash baseado no nome
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() { // sobrescreve o método toString para retornar uma representação em string da categoria
        return "Categoria{" +
                "descricao='" + descricao + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
