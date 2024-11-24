package model.entities; // pacote da entidade

import java.io.Serializable; // importa a interface Serializable
import java.util.*; // importa as classes utilitárias

public class Produto implements Serializable { // classe que representa um produto, implementa Serializable para permitir a serialização do objeto

    private Integer id; // identificador único do produto
    private String nome; // nome do produto
    private String descricao; // descrição do produto
    private Double precoCompra; // preço de compra do produto
    private Double precoVenda; // preço de venda do produto
    private Integer quantidade; // quantidade em estoque do produto
    private Categoria categoria; // categoria do produto

    public Produto() { // construtor padrão
    }

    public Produto(Integer id, String nome, String descricao, Double precoCompra, Double precoVenda, Integer quantidade, Categoria categoria) { // construtor com parâmetros
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    // getters e setters para os atributos da classe
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

    public String[] getTableFormat() { // retorna um array de strings com os dados do produto formatados para tabela
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


    public String getDataForSales(){ // retorna uma string com os dados do produto formatados para vendas
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(" | ");
        sb.append(precoVenda);
        sb.append(" | ");
        sb.append(quantidade);
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) { // sobrescreve o método equals para comparar produtos pelo nome
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() { // sobrescreve o método hashCode para gerar um código hash baseado no nome
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() { // sobrescreve o método toString para retornar uma representação em string do produto
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
