package application;


import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        Produto produto = produtoDao.findByName("a");


        List<Produto> list =  produtoDao.findAll();

        for (Produto p : list) {
            System.out.println(p);
        }
    }
}
