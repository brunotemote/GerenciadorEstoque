package model.impl;

import model.dao.CategoriaDao;
import model.entities.Categoria;
import model.entities.Produto;
import util.DB;
import util.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoJDBC implements CategoriaDao {

    private Connection conn;
    public CategoriaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    private Categoria instantiateCategoria(ResultSet rs) throws SQLException {
        Categoria cat = new Categoria();
        cat.setId(rs.getInt("id"));
        cat.setNome(rs.getString("nome"));
        cat.setDescricao(rs.getString("descricao"));
        return cat;
    }


    @Override
    public void insert(Categoria obj) {

    }

    @Override
    public Integer update(String novoNome, String novaDescricao, String antigoNome ) {
        PreparedStatement st = null;
        StringBuilder sql = new StringBuilder("UPDATE Categoria SET ");

        int rowsAffected = 0;

        if (!novoNome.isEmpty()) {
            sql.append("nome").append(" = ?, ");
        }
        if (!novaDescricao.isEmpty()) {
            sql.append("descricao").append(" = ?, ");
        }

        sql.setLength(sql.length() - 2);

        sql.append(" WHERE nome = ?");

        try{
            int index = 1;
            st = conn.prepareStatement(sql.toString());
            if (!novoNome.isEmpty()) {
                st.setString(index++, novoNome);
            }
            if (!novaDescricao.isEmpty()) {
                st.setString(index++, novaDescricao);
            }

            st.setString(index, antigoNome);

            rowsAffected = st.executeUpdate();

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

        return rowsAffected;
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Categoria findByName(String name) {
        return null;
    }

    @Override
    public List<Categoria> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("SELECT * FROM Categoria "
                    + "INNER JOIN Produto "
                    + "ON Produto.categoria_id = Categoria.id "
                    + "WHERE Produto.deleted = 0");
            rs = st.executeQuery();

            List<Categoria> list = new ArrayList<>();
            while(rs.next()){
                Categoria cat = instantiateCategoria(rs);
                list.add(cat);
            }
            return list;

        } catch (SQLException e){
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
