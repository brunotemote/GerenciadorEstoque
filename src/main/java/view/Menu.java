/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.configuration.ConfigurationComponents;
import view.configuration.TypeSelectMenu;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        ConfigurationComponents.iniciationTable(tableResultado);
        ConfigurationComponents.iniciationSelectMenu(selectMenuCategoria, TypeSelectMenu.CATEGORIA);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textFildProcurar = new javax.swing.JTextField();
        buttonAdicionar = new javax.swing.JButton();
        buttonProcurar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonAtualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResultado = new javax.swing.JTable();
        buttonAdicionar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonRelatorios = new javax.swing.JButton();
        buttonEditarCategoria = new javax.swing.JButton();
        buttonSimularVenda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectMenuCategoria = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAdicionar.setText("Adicionar Produto");
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        buttonProcurar.setText("Procurar");
        buttonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcurarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Atacadão dos Goianos");

        buttonAtualizar.setText("Atualizar Produto");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        tableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "descricao", "preco_compra", "preco_venda", "quantidade_estoque", "categoria_id", "nome_categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableResultado);

        buttonAdicionar1.setText("Remover Produto");
        buttonAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        buttonRelatorios.setText("Relatorios");
        buttonRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRelatorioActionPerformed(evt);
            }
        });

        buttonEditarCategoria.setText("Edição de Categoria");
        buttonEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarCategoriaActionPerformed(evt);
            }
        });

        buttonSimularVenda.setText("Simular Venda");
        buttonSimularVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimularVendaActionPerformed(evt);
            }
        });

        jLabel2.setText("Procurar por nome:");

        jLabel3.setText("Procurar por categoria:");

        selectMenuCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonEditarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAdicionar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonSimularVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(338, 338, 338))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFildProcurar)
                            .addComponent(selectMenuCategoria, 0, 156, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(390, 390, 390))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFildProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(selectMenuCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(buttonProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionar)
                    .addComponent(buttonAtualizar)
                    .addComponent(buttonAdicionar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRelatorios)
                    .addComponent(buttonEditarCategoria)
                    .addComponent(buttonSimularVenda))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void buttonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcurarActionPerformed
        String nome = textFildProcurar.getText();
        textFildProcurar.setText("");
        DefaultTableModel tableModel = (DefaultTableModel) tableResultado.getModel();

        ProdutoDao produtoDao = DaoFactory.createProdutoDao();

        // PESQUISA SOMENTE COM  A CATEGORIA
        if (selectMenuCategoria.getSelectedIndex() != 0 && nome.equals("") ){
            List<Produto> list = produtoDao.findAllByCategoria(new Categoria(null, null, selectMenuCategoria.getSelectedItem().toString() ));
            tableModel.setRowCount(0);
            for (Produto p : list){
                tableModel.addRow(p.getTableFormat());
            }
        }
        // RETORNAR TODOS OS DADOS
        else if (nome.equals("")){
            tableModel.setRowCount(0);
            ConfigurationComponents.iniciationTable(tableResultado);
            JOptionPane.showInternalMessageDialog(null, "Pesquisa realizada com sucesso! Retornando todos os resultados.");
            return;
        }
        //PESQUISA COM FILTRO DE NOME E CATEGORIA
        else if (!nome.equals("") && selectMenuCategoria.getSelectedIndex() != 0){
            Produto produto = produtoDao.findByNameAndCategory(nome, new Categoria(null, null,  selectMenuCategoria.getSelectedItem().toString()));
            if (produto == null){
                JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado no sistema.");
                return;
            }

            tableModel.setRowCount(0);
            tableModel.addRow(produto.getTableFormat());
        }
        // PESQUISA COM FILTRO DE NOME
        else{
            Produto produto = produtoDao.findByName(nome);
            if (produto == null){
                JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado no sistema.");
                return;
            }

            tableModel.setRowCount(0);
            tableModel.addRow(produto.getTableFormat());
        }

        JOptionPane.showMessageDialog(null, "Produto encontrado!");
    }//GEN-LAST:event_buttonProcurarActionPerformed

     private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
         AtualizarProduto ap = new AtualizarProduto();
         ap.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_buttonAtualizarActionPerformed
    
    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        InserirProduto ip = new InserirProduto();
        ip.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAdicionarActionPerformed
    
    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionar1ActionPerformed
        RemoverProduto rp = new RemoverProduto();
        rp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAdicionar1ActionPerformed

    private void buttonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionar1ActionPerformed
        Relatorios r = new Relatorios();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAdicionar1ActionPerformed

    private void buttonEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt){
        EditarCategoria ec = new EditarCategoria();
        ec.setVisible(true);
        this.dispose();
    }

    private void buttonSimularVendaActionPerformed(java.awt.event.ActionEvent evt){
        SimularVenda sv = new SimularVenda();
        sv.setVisible(true);
        this.dispose();
    }
    
    
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonAdicionar1;
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonEditarCategoria;
    private javax.swing.JButton buttonProcurar;
    private javax.swing.JButton buttonRelatorios;
    private javax.swing.JButton buttonSimularVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectMenuCategoria;
    private javax.swing.JTable tableResultado;
    private javax.swing.JTextField textFildProcurar;
}
