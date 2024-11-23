package model.dao;

import model.impl.CategoriaDaoJDBC;
import model.impl.ProdutoDaoJDBC;
import util.DB;

public class DaoFactory {

    public static ProdutoDao createProdutoDao(){
        return new ProdutoDaoJDBC(DB.getConnection());
    }

    public static CategoriaDao createCategoriaDao(){
        return new CategoriaDaoJDBC(DB.getConnection());
    }

}
