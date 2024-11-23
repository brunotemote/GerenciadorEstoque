/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

import javax.swing.*;

public class AtualizarProduto extends javax.swing.JFrame implements Navegacao {

    public AtualizarProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldEstoque = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        textFieldCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textFieldVenda = new javax.swing.JTextField();
        buttonVoltar = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Produto:");

        jLabel2.setText("Atualizar Estoque");

        jLabel3.setText("Atualizar Preco de Compra");

        jLabel4.setText("Atualizar Preco de Venda");

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt, AtualizarProduto.this);
            }
        });

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                        .addComponent(buttonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(textFieldCompra)
                                    .addComponent(textFieldVenda))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVoltar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(buttonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }
    

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        if (textFieldNome.getText().equals("")){
            JOptionPane.showInternalMessageDialog(null, "Por favor digite o nome do produto.");
            return;
        }
        if (textFieldCompra.getText().equals("")&&textFieldVenda.getText().equals("")&&textFieldEstoque.getText().equals("")){
            JOptionPane.showInternalMessageDialog(null, "Por favor digite pelo menos um dos valores.");
            return;
        }

        try {
            if ((!textFieldEstoque.getText().isEmpty() && Integer.parseInt(textFieldEstoque.getText()) <= 0) ||
                (!textFieldCompra.getText().isEmpty() && Float.parseFloat(textFieldCompra.getText()) <= 0) ||
                (!textFieldVenda.getText().isEmpty() && Float.parseFloat(textFieldVenda.getText()) <= 0)) {
                JOptionPane.showInternalMessageDialog(null, "Por favor insira valores maiores que zero.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Por favor insira valores numéricos válidos.");
            return;
        }
        
        Produto prod = produtoDao.findByName(textFieldNome.getText());
        if (prod == null){
            JOptionPane.showInternalMessageDialog(null, "Produto não encontrado! Verifique se digitou corretamente.");
            return;
        }

        int rowAffected = produtoDao.update(textFieldNome.getText(), textFieldCompra.getText(),textFieldVenda.getText(), textFieldEstoque.getText() );
        
        if (rowAffected == 0){
            JOptionPane.showInternalMessageDialog(null, "Erro ao atualizar produto.");
            return;
        }

        textFieldNome.setText("");
        textFieldEstoque.setText("");
        textFieldCompra.setText("");
        textFieldVenda.setText("");
        
        JOptionPane.showInternalMessageDialog(null, "Produto atualizado com sucesso!");
    }


    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textFieldCompra;
    private javax.swing.JTextField textFieldEstoque;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldVenda;
}
