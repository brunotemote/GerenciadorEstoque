package model.dao; // pacote do DAO (Data Access Object)

import model.impl.CategoriaDaoJDBC; // importa a classe CategoriaDaoJDBC
import model.impl.ProdutoDaoJDBC; // importa a classe ProdutoDaoJDBC
import util.DB; // importa a classe DB

public class DaoFactory { // classe que cria instâncias de DAOs

    public static ProdutoDao createProdutoDao(){ // cria uma instância de ProdutoDao
        return new ProdutoDaoJDBC(DB.getConnection()); // retorna uma nova instância de ProdutoDaoJDBC com a conexão do banco de dados
    }

    public static CategoriaDao createCategoriaDao(){ // cria uma instância de CategoriaDao
        return new CategoriaDaoJDBC(DB.getConnection()); // retorna uma nova instância de CategoriaDaoJDBC com a conexão do banco de dados
    }
}
