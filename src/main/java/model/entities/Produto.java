package model.entities;

import java.io.Serializable;
import java.util.*;

public class Produto implements Serializable {

    private Integer id;
    private String nome;
    private String descricao;
    private Double precoCompra;
    private Double precoVenda;
    private Integer quantidade;
    private Categoria categoria;


    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, Double precoCompra, Double precoVenda, Integer quantidade, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setprecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String[] getTableFormat() {
        List<Object> list = new ArrayList<>();
        list.add(id);
        list.add(nome);
        list.add(descricao);
        list.add(precoCompra);
        list.add(precoVenda);
        list.add(quantidade);
        list.add(categoria.getId());
        list.add(categoria.getNome());

        String[] stringArray = list.stream()
                .map(Object::toString)
                .toArray(String[]::new);

        return stringArray;
    }


    public String getDataForSales(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(" | ");
        sb.append(precoVenda);
        sb.append(" | ");
        sb.append(quantidade);
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "categoria=" + categoria +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", quantidade=" + quantidade +
                '}';
    }
}
