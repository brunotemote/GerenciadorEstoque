package application;


import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;
import view.Menu;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
