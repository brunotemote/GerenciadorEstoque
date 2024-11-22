/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

import javax.swing.*;

public class InserirProduto extends javax.swing.JFrame {

    public InserirProduto() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldDescricao = new javax.swing.JTextField();
        textFieldCompra = new javax.swing.JTextField();
        textFieldEstoque = new javax.swing.JTextField();
        textFieldNomeCategoria = new javax.swing.JTextField();
        textFieldDescricaoCategoria = new javax.swing.JTextField();
        volta = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textFieldVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Digite o nome:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Valor da compra:");

        jLabel4.setText("Quantidade Estoque:");

        jLabel5.setText("Nome da categoria:");

        jLabel6.setText("Descrição da categoria:");
        
        volta.setText("Voltar");
        volta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaActionPerformed(evt);
            }
        });

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor da venda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volta)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(textFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(textFieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldDescricaoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(volta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldNomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldDescricaoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void voltaActionPerformed(java.awt.event.ActionEvent evt) {
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {  
        String nome;
        String descricao;
        Double valorCompra;
        Double valorVenda;
        String nomeCategoria;
        String descricaoCategoria;
        Integer estoque;

        try{
            nome = textFieldNome.getText();
            descricao = textFieldDescricao.getText();
            valorCompra =  Double.parseDouble(textFieldCompra.getText());
            valorVenda = Double.parseDouble(textFieldVenda.getText());
            nomeCategoria = textFieldNomeCategoria.getText();
            descricaoCategoria = textFieldDescricaoCategoria.getText();
            estoque = Integer.parseInt(textFieldEstoque.getText());

        } catch (Exception e){
            JOptionPane.showInternalMessageDialog(null, "Nos campos de valores digite apenas os numeros e '.' ");
            return;
        }

        if (textFieldNome.getText().equals("") || textFieldDescricao.getText().equals("") || textFieldCompra.getText().equals("") || textFieldVenda.getText().equals("") || textFieldEstoque.getText().equals("") || textFieldNomeCategoria.getText().equals("") || textFieldDescricaoCategoria.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(null, "Por favor digite todos os dados.");
            return;
        }

        Produto prod = new Produto(null, nome, descricao, valorCompra, valorVenda, estoque, new Categoria(descricaoCategoria, null, nomeCategoria));

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        boolean isInserted = produtoDao.insert(prod);

        if (!isInserted){
            JOptionPane.showInternalMessageDialog(null, "Erro ao inserir o produto. Tente novamente!");
            return;
        }

        JOptionPane.showInternalMessageDialog(null, "Dados inserido com sucesso!");

        textFieldNome.setText("");
        textFieldDescricao.setText("");
        textFieldCompra.setText("");
        textFieldVenda.setText("");
        textFieldEstoque.setText("");
        textFieldNomeCategoria.setText("");
        textFieldDescricaoCategoria.setText("");
            
        
    }
    



    private javax.swing.JButton Enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textFieldCompra;
    private javax.swing.JTextField textFieldDescricao;
    private javax.swing.JTextField textFieldDescricaoCategoria;
    private javax.swing.JTextField textFieldEstoque;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldNomeCategoria;
    private javax.swing.JTextField textFieldVenda;
    private javax.swing.JButton volta;

}
