package model.impl;

import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;
import util.DB;
import util.DbException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Produto obj) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("CALL cadastro_produto(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getDescricao());
            st.setDouble(3, obj.getPrecoCompra());
            st.setDouble(4, obj.getPrecoVenda());
            st.setInt(5, obj.getQuantidade());
            st.setString(6, obj.getCategoria().getNome());
            st.setString(7, obj.getCategoria().getDescricao());

            int rowAffected = st.executeUpdate();

            if (rowAffected < 0){
                throw new DbException("Erro");
            }

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                obj.setId(id);
            }
            DB.closeResultSet(rs);
        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Produto obj) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Produto findByName(String name) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT Produto.*, Categoria.nome as nome_categoria, Categoria.descricao as descricao_categoria "
                    + "FROM Produto INNER JOIN Categoria "
                    + "ON Produto.categoria_id = Categoria.id "
                    + "WHERE Produto.nome = ?");

            st.setString(1, name);
            rs = st.executeQuery();

            if (!rs.next()) return null;

            Categoria cat = instantiateCategoria(rs);
            Produto prod = instantiateProduto(rs, cat);

            return prod;

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


    }

    private Produto instantiateProduto(ResultSet rs, Categoria cat) throws SQLException {
        Produto prod = new Produto();
        prod.setId(rs.getInt("id"));
        prod.setNome(rs.getString("nome"));
        prod.setDescricao(rs.getString("descricao"));
        prod.setPrecoCompra(rs.getDouble("preco_compra"));
        prod.setprecoVenda(rs.getDouble("preco_venda"));
        prod.setQuantidade(rs.getInt("quantidade_estoque"));
        prod.setCategoria(cat);
        return prod;
    }

    private Categoria instantiateCategoria(ResultSet rs) throws SQLException {
        Categoria cat = new Categoria();
        cat.setId(rs.getInt("categoria_id"));
        cat.setNome(rs.getString("nome_categoria"));
        cat.setDescricao(rs.getString("descricao_categoria"));
        return cat;
    }

    @Override
    public List<Produto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT Produto.*, Categoria.nome as nome_categoria, Categoria.descricao as descricao_categoria "
                        + "FROM Produto INNER JOIN Categoria "
                        + "ON Produto.categoria_id = Categoria.id "
                        + "ORDER BY nome;"
            );

            rs = st.executeQuery();

            List<Produto> list = new ArrayList<>();
            Map<Integer, Categoria> map = new HashMap<>();

            while (rs.next()){

                Categoria cat = map.get(rs.getInt("categoria_id"));

                if (cat == null){
                    cat = instantiateCategoria(rs);
                    map.put(rs.getInt("categoria_id"), cat);
                }

                Produto prod = instantiateProduto(rs, cat);
                list.add(prod);
            }
            return list;

        } catch (SQLException e ){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Produto> findByCategoria(Categoria categoria) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT Produto.*, Categoria.nome as nome_categoria, Categoria.descricao as descricao_categoria "
                    + "FROM Produto INNER JOIN Categoria "
                    + "ON Produto.categoria_id = Categoria.id "
                    + "WHERE Categoria.nome = ? "
                    + "ORDER BY nome;"
            );

            st.setString(1, categoria.getNome());

            rs = st.executeQuery();

            List<Produto> list = new ArrayList<>();
            Map<Integer, Categoria> map = new HashMap<>();

            while (rs.next()){

                Categoria cat = map.get(rs.getInt("categoria_id"));

                if (cat == null){
                    cat = instantiateCategoria(rs);
                    map.put(rs.getInt("categoria_id"), cat);
                }

                Produto prod = instantiateProduto(rs, cat);
                list.add(prod);
            }
            return list;

        } catch (SQLException e ){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }
}
