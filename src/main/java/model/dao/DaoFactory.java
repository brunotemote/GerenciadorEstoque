package model.dao;

import model.impl.ProdutoDaoJDBC;
import util.DB;

public class DaoFactory {

    public static ProdutoDao createProdutoDao(){
        return new ProdutoDaoJDBC(DB.getConnection());
    }

}
