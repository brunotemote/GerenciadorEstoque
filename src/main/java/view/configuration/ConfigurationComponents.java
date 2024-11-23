package view.configuration;

import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigurationComponents {
    // Adiciona os todos os dados das categorias no select menu
    public static void iniciationSelectMenu(JComboBox<String> selectMenu, TypeSelectMenu type) {

        List<String> allItens;
        if (type == TypeSelectMenu.CATEGORIA) {
            CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
            allItens = categoriaDao.findAll()
                    .stream()
                    .map(Categoria::getNome)
                    .collect(Collectors.toList());
        }
        else if (type == TypeSelectMenu.PRODUTO){
            ProdutoDao produtoDao = DaoFactory.createProdutoDao();
            allItens = produtoDao.findAll()
                    .stream()
                    .map(Produto::getDataForSales)
                    .collect(Collectors.toList());
        }
        else {
            throw new InvalidSelectMenuException("Tipo invalido de select menu");
        }

        selectMenu.removeAllItems();
        selectMenu.addItem(" ");
        allItens.forEach(selectMenu::addItem);
    }

    // Adciona todos os dados na tabela da interface
    public static void iniciationTable(JTable tableResultado) {
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        List<Produto> list = produtoDao.findAll();

        DefaultTableModel tableModel = (DefaultTableModel) tableResultado.getModel();

        for (Produto p : list){
            tableModel.addRow(p.getTableFormat());
        }
    }
}
